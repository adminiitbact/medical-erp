package org.iitbact.erp.controllers;
import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.entities.Facility;
import org.iitbact.erp.entities.FacilityAsset;
import org.iitbact.erp.entities.FacilityChecklist;
import org.iitbact.erp.entities.FacilityContact;
import org.iitbact.erp.entities.FacilityInventory;
import org.iitbact.erp.entities.FacilityMedstaff;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.services.FacilityServices;
import org.iitbact.erp.services.HospitalFacilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class FacilityController {
	
	@Autowired
	private FacilityServices facilityServices;
	
	
	@PostMapping(path = "/facility/{facilityId}")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean addFacilityData(@PathVariable int facilityId, @RequestBody FacilityRequest request) throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data=null;
		try {
			data=facilityServices.addFacilityData(facilityId, request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	@GetMapping(path = "/facility/{facilityId}")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean getFacilityData(@PathVariable int facilityId, @RequestParam String authToken) throws JsonProcessingException {
		HospitalErpError error = null;
		Facility data=null;
		try {
			data=facilityServices.fetchFacilityData(facilityId, authToken);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	@GetMapping(path = "/facility/{facilityId}/assets")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean getFacilityAssetsData(@PathVariable int facilityId, @RequestParam String authToken) throws JsonProcessingException {
		HospitalErpError error = null;
		FacilityAsset data=null;
		try {
			data=facilityServices.fetchFacilityData(facilityId, authToken).getFacilityAsset();
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	@GetMapping(path = "/facility/{facilityId}/inventory")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean getFacilityInventoryData(@PathVariable int facilityId, @RequestParam String authToken) throws JsonProcessingException {
		HospitalErpError error = null;
		FacilityInventory data=null;
		try {
			data=facilityServices.fetchFacilityData(facilityId, authToken).getFacilityInventory();
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	@GetMapping(path = "/facility/{facilityId}/contacts")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean getFacilityContactsData(@PathVariable int facilityId, @RequestParam String authToken) throws JsonProcessingException {
		HospitalErpError error = null;
		FacilityContact data=null;
		try {
			data=facilityServices.fetchFacilityData(facilityId, authToken).getFacilityContact();
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	@GetMapping(path = "/facility/{facilityId}/checklist")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean getFacilityChecklistData(@PathVariable int facilityId, @RequestParam String authToken) throws JsonProcessingException {
		HospitalErpError error = null;
		FacilityChecklist data=null;
		try {
			data=facilityServices.fetchFacilityData(facilityId, authToken).getFacilityChecklist();
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	@GetMapping(path = "/facility/{facilityId}/medstaff")
	@ApiOperation(response = BooleanResponse.class,value = "API request to add new data for a facility")
	public ResponseBean getFacilityMedstaffData(@PathVariable int facilityId, @RequestParam String authToken) throws JsonProcessingException {
		HospitalErpError error = null;
		FacilityMedstaff data=null;
		try {
			data=facilityServices.fetchFacilityData(facilityId, authToken).getFacilityMedstaff();
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	
	
	/*@PostMapping(path = "/fetch/facility/data")
	@ApiOperation(response = ErpUserProfile.class,value = "Api to add new data under facility")
	public ResponseBean fetchFacilityData(@RequestBody FlexibleRequest request) {
		HospitalErpError error = null;
		ErpUserProfile data= new ErpUserProfile();
		try {
			data=facilityServices.fetchFacilityData(request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
*/
}

