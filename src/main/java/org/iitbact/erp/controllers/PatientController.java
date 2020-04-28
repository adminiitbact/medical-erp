package org.iitbact.erp.controllers;

import java.text.ParseException;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.PatientDischargedRequestBean;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PostPatientRequestBean;
import org.iitbact.erp.requests.PatientTransferRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.PatientLiveStatusResponse;
import org.iitbact.erp.response.PatientProfileResponse;
import org.iitbact.erp.services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientServices patientServices;

	@PostMapping(path = "/patients/{patientId}/profile/get")
	@ApiOperation(response = PatientProfileResponse.class, value = "API to fetch patient's profile or biodata")
	public ResponseBean getPatientDetails(@PathVariable int patientId, @RequestBody BaseRequest request) {
		HospitalErpError error = null;
		PatientProfileResponse data = new PatientProfileResponse();
		try {
			data.setProfile(patientServices.getPatientProfile(patientId, request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

	@PostMapping(path = "/patients/{patientId}/profile/post")
	@ApiOperation(response = PatientProfileResponse.class, value = "API to update patient's profile or biodata")
	public ResponseBean updatePateintDetails(@PathVariable int patientId, @RequestBody PatientProfileRequestBean request) throws ParseException  {
		HospitalErpError error = null;
		PatientProfileResponse data = new PatientProfileResponse();;
		try {
			data.setProfile(patientServices.updatePatientProfile(patientId,request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
	
	@PostMapping(path = "/patients/new")
	@ApiOperation(response = BooleanResponse.class, value = "API request to add new patient's profile or biodata")
	public ResponseBean addPatient(@RequestBody PostPatientRequestBean request) throws ParseException {
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
	
	@PostMapping(path = "/patients/{patientId}/status/get")
	@ApiOperation(response = PatientLiveStatusResponse.class, value = "API to fetch live status for patients")
	public ResponseBean fetchPatientStatusLive(@PathVariable int patientId, @RequestBody BaseRequest request){
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
	
	@PostMapping(path = "/patients/{patientId}/status/post")
	@ApiOperation(response = BooleanResponse.class, value = "API to transfer facility/ Change Ward / or Update test and condition of a patient")
	public ResponseBean transferPatient(@PathVariable int patientId, @RequestBody PatientTransferRequestBean request) {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = (patientServices.patientStatusUpdate(patientId,request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}
	@PostMapping(path = "/patients/{patientId}/discharge/post")
	@ApiOperation(response = BooleanResponse.class, value = "API to discharge of a patient incase he is tested negative twice in a row or deceased ")
	public ResponseBean dischargePatient(@PathVariable int patientId, @RequestBody PatientDischargedRequestBean request) {
		HospitalErpError error = null;
		BooleanResponse data = null;
		try {
			data = (patientServices.dischargePatient(patientId,request));
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data, error);
		return responseBuilder.build();
	}

}
