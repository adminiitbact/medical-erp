package org.iitbact.erp.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.iitbact.erp.constants.Constants;
import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpErrorMsg;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PostPatientRequestBean;
import org.iitbact.erp.requests.WardRequestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Service
public class ApiValidationService {

	@Autowired
	private UserServices userServices;

	@Autowired
	private WardServices wardServices;

	@Autowired
	private PatientServices patientServices;

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiValidationService.class);

	public String verifyFirebaseIdToken(String authToken) {

		try {
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(authToken);
			String uid = decodedToken.getUid();
			return uid;
		} catch (FirebaseAuthException e) {
			LOGGER.error("Firebase token has expired or invalid!");
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
	}

	// Check for illegal access accross facility
	private void checkForUserFacility(String userId, int facilityId) {
		HospitalUser hospitalUser = userServices.userProfileWrtUserId(userId);

		if (facilityId != hospitalUser.getFacilityId()) {
			LOGGER.error("User with userId {} is trying to access data from another facility {}", userId, facilityId);
			System.out.println();
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
	}

	public void fetchAvailableWards(int facilityId, FacilityRequest request) {
		String userId = verifyFirebaseIdToken(request.getAuthToken());
		checkForUserFacility(userId, facilityId);
	}

	public Ward addAndUpdateWards(int facilityId, WardRequestBean request) {
		String userId = verifyFirebaseIdToken(request.getAuthToken());

		checkForUserFacility(userId, facilityId);

		if (request.getTotalBeds() < 0 || request.getVentilators() < 0 || request.getVentilatorsOccupied() < 0) {
			LOGGER.error(
					"Negative input for facility/ward - {}/{} (Totalbeds {} , Ventilators {}  OccupiedVentilators {})",
					facilityId, request.getWardId(), request.getTotalBeds(), request.getVentilators(),
					request.getVentilatorsOccupied());
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT, HospitalErpErrorMsg.NEGATIVE_VALUES);
		}

		Ward ward = null;
		if (request.getWardId() != 0) {
			ward = wardServices.findWardByIdAndFacilityId(request.getWardId(), facilityId);

			if (!ward.isActive()) {
				LOGGER.error("Ward is already deleted facility/ward - {}/{}", facilityId, request.getWardId());
				throw new HospitalErpException(HospitalErpErrorCode.WARD_NOT_ACTIVE,
						HospitalErpErrorMsg.WARD_NOT_ACTIVE);
			}

			int newAvailablity = ward.getAvailableBeds() + (request.getTotalBeds() - ward.getTotalBeds());
			if (newAvailablity < 0) {
				LOGGER.error(
						"Total beds cannot be less than beds total occupied beds within ward! facility/ward - {}/{}",
						facilityId, request.getWardId());
				throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT,
						HospitalErpErrorMsg.MORE_PATIENT_EXIST);
			}
		}
		return ward;
	}

	public Ward removeWard(int facilityId, int wardId, BaseRequest request) {
		String userId = verifyFirebaseIdToken(request.getAuthToken());

		checkForUserFacility(userId, facilityId);

		Ward ward = wardServices.findWardByIdAndFacilityId(wardId, facilityId);

		if (!ward.isActive()) {
			throw new HospitalErpException(HospitalErpErrorCode.WARD_NOT_ACTIVE, HospitalErpErrorMsg.WARD_NOT_ACTIVE);
		}

		if (ward.getAvailableBeds() != ward.getTotalBeds()) {
			LOGGER.error("Ward is occupied! facility/ward - {}/{}", facilityId, ward.getId());
			throw new HospitalErpException(HospitalErpErrorCode.REMOVE_WARD_FAILED,
					HospitalErpErrorMsg.REMOVE_WARD_FAILED);
		}
		return ward;
	}

	public Patient addPatient(PostPatientRequestBean request) throws ParseException {
		verifyFirebaseIdToken(request.getAuthToken());
		isDateValid(request.getDob());
		return new Patient(request);
	}

	private void isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat(Constants.MYSQL_FORMAT_REVERSE);
			df.setLenient(false);
			df.parse(date);
		} catch (ParseException e) {
			LOGGER.error("Patient dob is in Invalid format! dob - ", date);
			throw new HospitalErpException(HospitalErpErrorCode.DATE_FORMAT_ERROR,
					HospitalErpErrorMsg.DATE_FORMAT_ERROR);

		}
	}

	public Patient updatePatientProfile(int patientId, PatientProfileRequestBean request) {
		verifyFirebaseIdToken(request.getAuthToken());
		isDateValid(request.getDob());
		return patientServices.findById(patientId);
	}

}
