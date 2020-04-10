package org.iitbact.erp.services;

import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.repository.PatientRepository;
import org.iitbact.erp.requests.FlexibleRequest;
import org.iitbact.erp.response.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PatientServices {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private ApiValidationService validationService;

	private void authenticateUser(String authToken) {
		validationService.verifyFirebaseIdToken(authToken);
	}

	public BooleanResponse addPatient(FlexibleRequest request) {
		//this.authenticateUser(request.getAuthToken());

		ObjectMapper mapper = new ObjectMapper();
		JsonNode data = mapper.convertValue(request.getData(), JsonNode.class);
		if (data != null) {
			//Patient patient = new Patient(data);
		//	patientRepository.save(patient);
		}

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}
}
