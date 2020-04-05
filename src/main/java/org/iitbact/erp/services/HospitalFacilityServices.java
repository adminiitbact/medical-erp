package org.iitbact.erp.services;

import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.repository.UserRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ErpUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalFacilityServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ApiValidationService validationService;

	public ErpUserProfile profile(BaseRequest request) {
		String userId = validationService.verifyFirebaseIdToken(request);
		HospitalUser user = userRepository.findByUserId(userId);
		ErpUserProfile response = new ErpUserProfile();
		response.setProfile(user);
		return response;
	}

	public BooleanResponse addFacilityData(FlexibleRequest request) {
		String userId = validationService.verifyFirebaseIdToken(request);
		
		HospitalUser user = userRepository.findByUserId(userId);
		
		System.out.println("Input fields from frontend : "+ request.getData().toPrettyString());
		
		BooleanResponse data=new BooleanResponse(true);
		
		return data;
	}

}
