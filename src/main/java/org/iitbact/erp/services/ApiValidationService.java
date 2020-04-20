package org.iitbact.erp.services;

import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpErrorMsg;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.WardRequestBean;
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

	public String verifyFirebaseIdToken(String authToken) {

		try {
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(authToken);
			String uid = decodedToken.getUid();
			return uid;
		} catch (FirebaseAuthException e) {
			System.out.println("Firebase token has expired or invalid!");
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
	}

	// Check for illegal access accross facility
	private void checkForUserFacility(String userId, int facilityId) {
		HospitalUser hospitalUser = userServices.userProfileWrtUserId(userId);

		if (facilityId != hospitalUser.getFacilityId()) {
			System.out.println("Trying to access another facility data " + userId);
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE,
					HospitalErpErrorMsg.INVALID_ACCESS_CODE);
		}
	}

	public void fetchAvailableWards(int facilityId, FacilityRequest request) {
		String userId = verifyFirebaseIdToken(request.getAuthToken());
		checkForUserFacility(userId, facilityId);
	}
	
	//we are not deleting ward just soft removing it , so what will happen if someone add the same name/bulding/floor tupple again?//TODO
	public Ward addAndUpdateWards(int facilityId, WardRequestBean request) {
		String userId = verifyFirebaseIdToken(request.getAuthToken());

		checkForUserFacility(userId, facilityId);

		if (request.getTotalBeds() < 0 || request.getVentilators() < 0 || request.getVentilatorsOccupied() < 0) {
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT,HospitalErpErrorMsg.NEGATIVE_VALUES);
		}

		Ward ward = null;
		if (request.getWardId() != 0) {
			ward = wardServices.findWardByIdAndFacilityId(request.getWardId(), facilityId);
			
			if(!ward.isActive()) {
				throw new HospitalErpException(HospitalErpErrorCode.WARD_NOT_ACTIVE,HospitalErpErrorMsg.WARD_NOT_ACTIVE);
			}
			
			int newAvailablity = ward.getAvailableBeds() + (request.getTotalBeds() - ward.getTotalBeds());
			if (newAvailablity < 0) {
				throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT,HospitalErpErrorMsg.MORE_PATIENT_EXIST);
			}
		}
		return ward;
	}

	public Ward removeWard(int facilityId, int wardId, BaseRequest request) {
		String userId = verifyFirebaseIdToken(request.getAuthToken());

		checkForUserFacility(userId, facilityId);

		Ward ward = wardServices.findWardByIdAndFacilityId(wardId, facilityId);
		
		if(!ward.isActive()) {
			throw new HospitalErpException(HospitalErpErrorCode.WARD_NOT_ACTIVE,HospitalErpErrorMsg.WARD_NOT_ACTIVE);
		}
		
		if (ward.getAvailableBeds() != ward.getTotalBeds()) {
			throw new HospitalErpException(HospitalErpErrorCode.REMOVE_WARD_FAILED,
					HospitalErpErrorMsg.REMOVE_WARD_FAILED);
		}
		return ward;
	}

}
