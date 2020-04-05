package org.iitbact.erp.controllers;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ErpUserProfile;
import org.iitbact.erp.services.HospitalFacilityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class HospitalFacilityController {
	
	@Autowired
	private HospitalFacilityServices facilityServices;
	
	
	@PostMapping(path = "/add/facility/data")
	@ApiOperation(response = ErpUserProfile.class,value = "Api to add new data under facility")
	public ResponseBean addFacilityData(@RequestBody FlexibleRequest request) {
		HospitalErpError error = null;
		BooleanResponse data=null;
		try {
			data=facilityServices.addFacilityData(request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}

}
