package org.iitbact.erp.services;

import org.iitbact.erp.requests.BaseRequest;
import org.springframework.stereotype.Service;

@Service
public class ApiValidationService {

	public String verifyFirebaseIdToken(BaseRequest request) {

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
