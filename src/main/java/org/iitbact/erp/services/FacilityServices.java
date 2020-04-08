package org.iitbact.erp.services;



import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.FacilityAsset;
import org.iitbact.erp.entities.FacilityChecklist;
import org.iitbact.erp.entities.HospitalUser;
import org.iitbact.erp.repository.FacilityRepository;
import org.iitbact.erp.repository.UserRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ErpUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FacilityServices {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ApiValidationService validationService;

	public ErpUserProfile profile(BaseRequest request) {
		String userId = validationService.verifyFirebaseIdToken(request);
		HospitalUser user = userRepository.findByUserId(userId);
		ErpUserProfile response = new ErpUserProfile();
		response.setProfile(user);
		return response;
	}

	public BooleanResponse addFacilityData(int facilityId, FacilityRequest request) throws JsonProcessingException {
		if (!this.authenticateUser(request.getAuthToken())) {
			//Raise some error
		}
		Facility facility = facilityRepository.findByFacilityId(facilityId);
		facility.setName(request.getName());
		facility.setArea(request.getArea());
		facility.setJurisdiction(request.getJurisdiction());
		facility.setFacilityType(request.getFacilityType());
		facility.setGovernmentHospital((byte) (request.getGovernmentHospital()?1:0));
		facility.setTelephone(request.getTelephone());
		facility.setEmail(request.getEmail());
		Object data;
		data = request.getChecklistData();
		if (data != null) {
			facility.getFacilityChecklist().setData(data);
		}
		data = request.getAssetsData();
		if (data != null) {
			facility.getFacilityAsset().setData(data);
		}
		data = request.getMedStaffData();
		if (data != null) {
			facility.getFacilityMedstaff().setData(data);
		}
		data = request.getInventoryData();
		if (data != null) {
			facility.getFacilityInventory().setData(data);
		}
		data = request.getContactsData();
		if (data != null) {
			facility.getFacilityContact().setData(data);
		}

		facilityRepository.save(facility);
		BooleanResponse returnVal=new BooleanResponse(true);	
		return returnVal;
	}
	
	private boolean authenticateUser(String authToken) {
		String userId = validationService.verifyFirebaseIdToken(authToken);
		HospitalUser user = userRepository.findByUserId(userId);
		//TODO: If user.facilityId == facilityId or user should be able to access this data then continue, else throw error
		return true;
	}

	public Facility fetchFacilityData(int facilityId, String authToken) {
		if (!this.authenticateUser(authToken)) {
			//Raise some error
		}
		Facility facility = facilityRepository.findByFacilityId(facilityId);
		return facility;
	}
}