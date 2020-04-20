package org.iitbact.erp.controllers;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.WardRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ListResponse;
import org.iitbact.erp.services.WardServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class WardController {
	@Autowired
	private WardServices wardServices;

	@PostMapping(path = "/facilities/{facilityId}/wards/get")
	@ApiOperation(response = Ward.class, responseContainer = "List", value = "API request to fetch all available wards from facilities")
	public ResponseBean fetchAvailableWards(@PathVariable int facilityId, @RequestBody FacilityRequest request) {
		HospitalErpError error = null;
		ListResponse<Ward> data = new ListResponse<>();
		try {
			data.setList(wardServices.fetchAvailableWards(facilityId, request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/facilities/{facilityId}/wards/post")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add/update a ward to a facilities")
	public ResponseBean addAndUpdateWards(@PathVariable int facilityId, @RequestBody WardRequestBean request) {
		HospitalErpError error = null;
		BooleanResponse data = new BooleanResponse();
		try {
			data = (wardServices.addAndUpdateWards(facilityId, request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
	
	@PostMapping(path = "/facilities/{facilityId}/wards/{wardId}/remove")
	@ApiOperation(response = BooleanResponse.class, value = "API to remove a ward from a facilities given no patient is allocated to the ward")
	public ResponseBean removeWard(@PathVariable int facilityId,@PathVariable int wardId,@RequestBody BaseRequest request) {
		HospitalErpError error = null;
		BooleanResponse data = new BooleanResponse();
		try {
			data = (wardServices.removeWard(facilityId,wardId,request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
}
