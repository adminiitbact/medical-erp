package org.iitbact.erp.services;

import java.text.ParseException;

import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientClinicalHist;
import org.iitbact.erp.entities.PatientCovidTestDetails;
import org.iitbact.erp.entities.PatientLiveStatus;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpErrorMsg;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.PatientDischargedRequestBean;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PatientTransferRequestBean;
import org.iitbact.erp.requests.PostPatientClinicalHistBean;
import org.iitbact.erp.requests.PostPatientCovidTestDetailsBean;
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
	public HospitalUser checkForUserFacility(String userId, int facilityId) {
		HospitalUser hospitalUser = userServices.userProfileWrtUserId(userId);
		if (facilityId != hospitalUser.getFacilityId()) {
			LOGGER.error("User with userId {} is trying to access data from another facility {}", userId, facilityId);
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
		return hospitalUser;
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
		String uid = verifyFirebaseIdToken(request.getAuthToken());

		checkForUserFacility(uid, request.getFacilityId());

		if (request.getWardId() != 0) {
			wardServices.findWardByIdAndFacilityId(request.getWardId(), request.getFacilityId());
		}
		isMonthValid(request.getMonth());
		return new Patient(request);
	}

	public PatientClinicalHist addPatientClinicalHist(PostPatientClinicalHistBean request) throws ParseException {
		return new PatientClinicalHist(request);
	}

	public PatientCovidTestDetails addPatientCovidTestDetails(PostPatientCovidTestDetailsBean request) throws ParseException {
		return new PatientCovidTestDetails(request);
	}

	/*
	 * private void isDateValid(String date) { try { DateFormat df = new
	 * SimpleDateFormat(Constants.MYSQL_FORMAT); df.setLenient(false);
	 * df.parse(date); } catch (ParseException e) { LOGGER.error(
	 * "Patient dob is in Invalid format! dob - ", date); throw new
	 * HospitalErpException(HospitalErpErrorCode.DATE_FORMAT_ERROR,
	 * HospitalErpErrorMsg.DATE_FORMAT_ERROR);
	 * 
	 * } }
	 */

	private void isMonthValid(int month) {
		if (!(0 <= month && month <= 12)) {
			LOGGER.error("Patient month is in Invalid! month - ", month);
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT, HospitalErpErrorMsg.INVALID_INPUT);
		}

	}

	public Patient updatePatientProfile(int patientId, PatientProfileRequestBean request) {
		String uid = verifyFirebaseIdToken(request.getAuthToken());
		HospitalUser user = userServices.userProfileWrtUserId(uid);

		PatientLiveStatus patientCurrentStatus = patientServices.patientLiveStatus(patientId);

		if (patientCurrentStatus.getFacilityId() != user.getFacilityId()) {
			LOGGER.error("Trying to updatePatientProfile a patient {} from another facility! UserId {}", patientId,
					user.getEmailId());
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
		isMonthValid(request.getMonth());
		return patientServices.findById(patientId);
	}

	public HospitalUser checkUserFacility(int facilityId, BaseRequest request) {
		String uid = verifyFirebaseIdToken(request.getAuthToken());
		return checkForUserFacility(uid, facilityId);
	}

	public PatientLiveStatus dischargePatient(int patientId, PatientDischargedRequestBean request) {
		String uid = verifyFirebaseIdToken(request.getAuthToken());
		HospitalUser user = checkForUserFacility(uid, request.getFacilityId());

		PatientLiveStatus patientCurrentStatus = patientServices.patientLiveStatus(patientId);

		if (patientCurrentStatus.getFacilityId() != user.getFacilityId()) {
			LOGGER.error("Trying to dishcarge a patient {} from another facility! UserId {}", patientId,
					user.getEmailId());
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
		return patientCurrentStatus;
	}

	public HospitalUser fetchPatientStatusLive(BaseRequest request) {
		String uid = verifyFirebaseIdToken(request.getAuthToken());
		HospitalUser hospitalUser = userServices.userProfileWrtUserId(uid);
		return hospitalUser;
	}

	public void getPatientProfile(int patientId, BaseRequest request) {
		String uid = verifyFirebaseIdToken(request.getAuthToken());
		HospitalUser user = userServices.userProfileWrtUserId(uid);

		PatientLiveStatus patientCurrentStatus = patientServices.patientLiveStatus(patientId);

		if (patientCurrentStatus.getFacilityId() != user.getFacilityId()) {
			LOGGER.error("Trying to getPatientProfile a patient {} from another facility! UserId {}", patientId,
					user.getEmailId());
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
	}

	public PatientLiveStatus patientStatusUpdate(int patientId, PatientTransferRequestBean request) {
		String uid = verifyFirebaseIdToken(request.getAuthToken());

		HospitalUser user = userServices.userProfileWrtUserId(uid);

		PatientLiveStatus patientCurrentStatus = patientServices.patientLiveStatus(patientId);

		if (patientCurrentStatus.getFacilityId() != user.getFacilityId()) {
			LOGGER.error("Trying to update status of patient {} from another facility! UserId {}", patientId,
					user.getEmailId());
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}

		if (request.getWardId() != 0) {
			wardServices.findWardByIdAndFacilityId(request.getWardId(), request.getFacilityId());
		}

		return patientCurrentStatus;
	}

}
