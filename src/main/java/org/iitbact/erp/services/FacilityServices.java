package org.iitbact.erp.services;

import java.util.List;

import org.iitbact.erp.constants.Constants;
import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.iitbact.erp.repository.FacilityRepository;
import org.iitbact.erp.repository.PatientLiveStatusRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FacilityServices {

	@Autowired
	private FacilityRepository facilityRepository;

	@Autowired
	private ApiValidationService validationService;
	
	@Autowired
	private PatientLiveStatusRepository patientLiveStatusRepository;

	private void authenticateUser(String authToken) {
		validationService.verifyFirebaseIdToken(authToken);
		// userRepository.findByUserId(userId);
		// TODO: If user.facilityId == facilityId or user should be able to
		// access this
		// data then continue, else throw error
		// throw runtime hospital exception
	}

	public BooleanResponse addFacilityProfileData(int facilityId, FlexibleRequest request)
			throws JsonProcessingException {
		this.authenticateUser(request.getAuthToken());

		Facility facility = facilityRepository.findById(facilityId).get();

		ObjectMapper mapper = new ObjectMapper();
		JsonNode data = mapper.convertValue(request.getData(), JsonNode.class);
		facility.updateProfileData(data.get(Constants.FACILITY_DATA));
		if (data != null) {
			facility.getFacilityContact().setData(data.get(Constants.CONTACT_DATA));
		}
		facilityRepository.save(facility);
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public BooleanResponse addFacilityAssets(int facilityId, FlexibleRequest request) throws JsonProcessingException {
		this.authenticateUser(request.getAuthToken());
		Facility facility = facilityRepository.findById(facilityId).get();
		Object data = request.getData();
		if (data != null) {
			facility.getFacilityAsset().setData(data);
		}
		facilityRepository.save(facility);
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public BooleanResponse addFacilityInventory(int facilityId, FlexibleRequest request)
			throws JsonProcessingException {
		this.authenticateUser(request.getAuthToken());
		Facility facility = facilityRepository.findById(facilityId).get();
		Object data = request.getData();
		if (data != null) {
			facility.getFacilityInventory().setData(data);
		}
		facilityRepository.save(facility);
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public BooleanResponse addFacilityMedstaff(int facilityId, FlexibleRequest request) throws JsonProcessingException {
		this.authenticateUser(request.getAuthToken());
		Facility facility = facilityRepository.findById(facilityId).get();
		Object data = request.getData();
		if (data != null) {
			facility.getFacilityMedstaff().setData(data);
		}
		facilityRepository.save(facility);
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public BooleanResponse addFacilityChecklist(int facilityId, FlexibleRequest request)
			throws JsonProcessingException {
		this.authenticateUser(request.getAuthToken());
		Facility facility = facilityRepository.findById(facilityId).get();
		Object data = request.getData();
		if (data != null) {
			facility.getFacilityChecklist().setData(data);
		}
		facilityRepository.save(facility);
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public Facility fetchFacilityData(int facilityId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		Facility facility = facilityRepository.findById(facilityId).get();
		return facility;
	}

	public List<PatientLiveStatusInterface> searchPatientByFacility(int facility_id, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientLiveStatusRepository.findByFacilityId(facility_id);
	}

}
