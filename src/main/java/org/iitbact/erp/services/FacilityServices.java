package org.iitbact.erp.services;

import java.util.ArrayList;
import java.util.List;

import org.iitbact.erp.beans.FacilityProfileWithAvailablity;
import org.iitbact.erp.constants.Constants;
import org.iitbact.erp.constants.TEST_STATUS;
import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.FacilityDetails;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.repository.FacilityRepository;
import org.iitbact.erp.repository.PatientLiveStatusRepository;
import org.iitbact.erp.repository.WardRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
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
	private WardRepository wardRepository;

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
		facility.updateProfileData(data.get(Constants.FACILITY_DATA));//TODO
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

	public List<PatientLiveStatusInterface> searchPatientByFacility(int facilityId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientLiveStatusRepository.findByFacilityId(facilityId);
	}

	public List<Ward> fetchAvailableWards(int facilityId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return wardRepository.findByFacilityId(facilityId);
	}

	//

	public List<FacilityProfileWithAvailablity> facilities(FacilityRequest request) {
		this.authenticateUser(request.getAuthToken());

		String covidStatus = getCovidStatus(request.getTestStatus().toString());

		List<FacilityDetails> facilities = null;
		//List<FacilityAssignedPatients> assignedPatients=null;//TODO do something about it
		
		// Fetch facilities based on covid status (suspected/confirmed)
		if (covidStatus != null) {
			facilities = facilityRepository.getFacilities(covidStatus,
					request.getSeverity().toString());
			/*
			 * assignedPatients = facilityRepository
			 * .assignedPatients(request.getSeverity().toString(),
			 * request.getTestStatus().toString());
			 */
		}else {
			facilities = facilityRepository.getFacilities();//TODO what to do in case of nagative
			/*
			 * assignedPatients = facilityRepository .assignedPatients();
			 */
		}
		

		// Create Response
		List<FacilityProfileWithAvailablity> data = new ArrayList<FacilityProfileWithAvailablity>();
		
		for (FacilityDetails facility : facilities) {
			FacilityProfileWithAvailablity facilityProfileWithAvailablity = new FacilityProfileWithAvailablity(
					facility);
			
			/*
			 * if(!assignedPatients.isEmpty()) { FacilityAssignedPatients totalAssigned =
			 * assignedPatients.stream().filter(x ->
			 * facilityProfileWithAvailablity.getFacilityId() ==
			 * x.getFacilityId()).findAny().get();
			 * 
			 * if (totalAssigned != null) {
			 * facilityProfileWithAvailablity.substractAssigned(totalAssigned.
			 * getTotalAssigned()); } }
			 */
			
			data.add(facilityProfileWithAvailablity);
		}
		return data;
	}

	private String getCovidStatus(String testStatus) {
		if (TEST_STATUS.POSITIVE.toString().equalsIgnoreCase(testStatus)) {
			return Constants.CONFIRMED;
		} else if (TEST_STATUS.NEGATIVE.toString().equalsIgnoreCase(testStatus)) {
			return null;
		}
		return Constants.SUSPECTED;
	}

}
