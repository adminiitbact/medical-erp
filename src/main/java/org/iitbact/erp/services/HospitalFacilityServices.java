package org.iitbact.erp.services;

import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.entities.Temp;
import org.iitbact.erp.repository.TempRepository;
import org.iitbact.erp.repository.UserRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ErpUserProfile;
import org.iitbact.erp.response.FacilityProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HospitalFacilityServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TempRepository tempRepository;

	
	@Autowired
	private ApiValidationService validationService;

	public ErpUserProfile profile(BaseRequest request) {
		String userId = validationService.verifyFirebaseIdToken(request);
		HospitalUser user = userRepository.findByUserId(userId);
		ErpUserProfile response = new ErpUserProfile();
		response.setProfile(user);
		return response;
	}

	public BooleanResponse addFacilityData(FlexibleRequest request) throws JsonProcessingException {
		String userId = validationService.verifyFirebaseIdToken(request);
		
		HospitalUser user = userRepository.findByUserId(userId);
		
		Temp temp = new Temp();
		ObjectMapper mapper = new ObjectMapper();
		
		temp.setData(mapper.writeValueAsString(request));
		Temp temp2 = tempRepository.saveAndFlush(temp);
		System.out.println(temp2.getId());
		
		System.out.println("Input fields from frontend : "+ request.getData());
		
		BooleanResponse data=new BooleanResponse(true);	
		
		return data;
	}

	public FacilityProfile facilityProfile(BaseRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
