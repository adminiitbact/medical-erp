package org.iitbact.erp.services;

import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpErrorMsg;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.repository.UserRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.response.ErpUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ApiValidationService validationService;

	public HospitalUser userProfileWrtUserId(String userId) {
		try {
			HospitalUser user = userRepository.findByUserId(userId);
			if (user == null) {
				System.out.println("UserId not found : " + userId);
				throw new HospitalErpException(HospitalErpErrorCode.DATABASE_ERROR, HospitalErpErrorMsg.DATABASE_ERROR);
			}
			return user;
		} catch (Exception e) {
			System.out.println("System Error " + userId);
			throw new HospitalErpException(HospitalErpErrorCode.DATABASE_ERROR, HospitalErpErrorMsg.DATABASE_ERROR);
		}
	}

	public ErpUserProfile profile(BaseRequest request) {
		
		String userId = validationService.verifyFirebaseIdToken(request.getAuthToken());
		
		HospitalUser user = userProfileWrtUserId(userId);
		
		ErpUserProfile response = new ErpUserProfile();
		response.setProfile(user);
		return response;
	}
}
