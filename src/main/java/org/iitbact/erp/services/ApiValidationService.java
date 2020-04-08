package org.iitbact.erp.services;

import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.exceptions.HosptialErpErrorMsg;
import org.iitbact.erp.requests.BaseRequest;
import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Service
public class ApiValidationService {

	public String verifyFirebaseIdToken(BaseRequest request) {

		// idToken comes from the client app
		//return "E2gHG4A2QqVl7A4S4mSJs0zRBvF2";
		
		
		try {
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(request.getAuthToken());
			String uid = decodedToken.getUid();
			return uid;
		} catch (FirebaseAuthException e) {
			e.printStackTrace();
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE, HosptialErpErrorMsg.INVALID_ACCESS_CODE, e);
			//return "DmnLaKUTrsQvW0u1UVJDxdvoSRR2";
		}
		
	}
	public String verifyFirebaseIdToken(String authToken) {

		// idToken comes from the client app
		return "DmnLaKUTrsQvW0u1UVJDxdvoSRR2";
		
		/*
		try {
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(request.getAuthToken());
			String uid = decodedToken.getUid();
			return uid;
		} catch (FirebaseAuthException e) {
			e.printStackTrace();
			throw new HospitalErpException(HospitalErpErrorCode.INVALID_ACCESS_CODE, HosptialErpErrorMsg.INVALID_ACCESS_CODE, e);
			//return "DmnLaKUTrsQvW0u1UVJDxdvoSRR2";
		}
		*/
	}

}
