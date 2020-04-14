package org.iitbact.erp.services;

import org.iitbact.erp.entities.AdminUser;
import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.repository.AdminUserRepository;
import org.iitbact.erp.repository.UserRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.response.AdminUserProfile;
import org.iitbact.erp.response.ErpUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminUserRepository adminUserRepository;
	
	

	@Autowired
	private ApiValidationService validationService;

	public ErpUserProfile profile(BaseRequest request) {
		String userId = validationService.verifyFirebaseIdToken(request.getAuthToken());
		HospitalUser user = userRepository.findByUserId(userId);
		ErpUserProfile response = new ErpUserProfile();
		response.setProfile(user);
		return response;
	}

	public AdminUserProfile adminProfile(BaseRequest request) {
		String userId = validationService.verifyFirebaseIdToken(request.getAuthToken());
		AdminUser user = adminUserRepository.findByUserId(userId);
		AdminUserProfile response = new AdminUserProfile();
		response.setProfile(user);
		return response;
	}

}
