package org.iitbact.erp.controllers;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	PatientServices patientServices;
	
	@PostMapping(path = "/add")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add checklists for a facility")
	public ResponseBean addPatient(@RequestBody FlexibleRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = patientServices.addPatient(request);

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
}
