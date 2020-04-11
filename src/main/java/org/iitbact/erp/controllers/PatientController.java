package org.iitbact.erp.controllers;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientLiveStatus;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.PatientRequestBean;
import org.iitbact.erp.requests.PatientUpdateRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.ListResponse;
import org.iitbact.erp.response.PatientLiveStatusResponse;
import org.iitbact.erp.response.PatientResponse;
import org.iitbact.erp.services.PatientServices;
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
public class PatientController {

	@Autowired
	PatientServices patientServices;

	@PostMapping(path = "/register/patient")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add new patient's into database")
	public ResponseBean addPatient(@RequestBody PatientRequestBean request) throws JsonProcessingException {
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

	@PostMapping(path = "/search/patient/byname/{name}")
	@ApiOperation(response = Patient.class, responseContainer = "List", value = "API Search Patient By Name. Returns a list of patients")
	public ResponseBean searchPatientByName(@PathVariable String name, @RequestBody BaseRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		ListResponse<Patient> data = new ListResponse<>();
		try {
			data.setList(patientServices.searchPatientByName(name, request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/patient/details/{id}")
	@ApiOperation(response = Patient.class, value = "API to fetch pateint's details")
	public ResponseBean getPatientDetails(@PathVariable int id, @RequestBody BaseRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		PatientResponse data = new PatientResponse();
		try {
			data.setPatientDetails(patientServices.getPatientDetails(id, request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/update/patient/details")
	@ApiOperation(response = BooleanResponse.class, value = "API to update patient's details")
	public ResponseBean updatePateintDetails(@RequestBody PatientUpdateRequestBean request) throws JsonProcessingException {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data =  (patientServices.updatePatientDetails(request));

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/patient/live/status/{patientId}")
	@ApiOperation(response = PatientLiveStatus.class, value = "API to fetch live status for patient with patient Details")
	public ResponseBean fetchPatientStatusLive(@PathVariable int patientId, @RequestBody BaseRequest request)
			throws JsonProcessingException {
		HospitalErpError error = null;
		PatientLiveStatusResponse data = null;
		try {
			data = (patientServices.fetchPatientStatusLive(patientId, request));

		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

}
