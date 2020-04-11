package org.iitbact.erp.controllers;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.AvailableFacilityRequest;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ListResponse;
import org.iitbact.erp.services.FacilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class FacilityController {

	@Autowired
	private FacilityServices facilityServices;

	@PostMapping(path = "/facility/{facilityId}")
	@ApiOperation(response = Facility.class, value = "API request to fetch a facility data")
	public ResponseBean getFacilityData(@PathVariable int facilityId, @RequestBody BaseRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		Facility data = null;
		try {
			data = facilityServices.fetchFacilityData(facilityId, request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/add/facility/profile/{facilityId}")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add profile data for a facility")
	public ResponseBean addFacilityProfileData(@PathVariable int facilityId, @RequestBody FlexibleRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = facilityServices.addFacilityProfileData(facilityId, request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/facility/{facilityId}/assets")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add assets for a facility")
	public ResponseBean addFacilityAssets(@PathVariable int facilityId, @RequestBody FlexibleRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = facilityServices.addFacilityAssets(facilityId, request);

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/facility/{facilityId}/inventory")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add inventory for a facility")
	public ResponseBean addFacilityInventory(@PathVariable int facilityId, @RequestBody FlexibleRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = facilityServices.addFacilityInventory(facilityId, request);

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/facility/{facilityId}/medstaff")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add med staff for a facility")
	public ResponseBean addFacilityMedstaff(@PathVariable int facilityId, @RequestBody FlexibleRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = facilityServices.addFacilityMedstaff(facilityId, request);

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/facility/{facilityId}/checklist")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add checklists for a facility")
	public ResponseBean addFacilityChecklist(@PathVariable int facilityId, @RequestBody FlexibleRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = facilityServices.addFacilityChecklist(facilityId, request);

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
	
	
	@PostMapping(path = "/list/patients/{facilityId}")
	@ApiOperation(response = Patient.class, value = "API to fetch list of patients from a particuar facility. Returns a list of patients")
	public ResponseBean searchPatientByFacility(@PathVariable int facilityId, @RequestBody BaseRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		ListResponse<PatientLiveStatusInterface> data = new ListResponse<>();
		try {
			data.setList(facilityServices.searchPatientByFacility(facilityId, request));

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
	
	//TODO
	@PostMapping(path = "/available/facilities")
	@ApiOperation(response = BooleanResponse.class, value = " TODO : API request to fetch all available facilities")
	public ResponseBean availableFacilities(@RequestBody AvailableFacilityRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			//data = facilityServices.addFacilityChecklist(facilityId, request);

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

}
