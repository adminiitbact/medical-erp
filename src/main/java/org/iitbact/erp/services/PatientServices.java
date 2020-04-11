package org.iitbact.erp.services;

import java.util.List;

import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.iitbact.erp.repository.PatientLiveStatusRepository;
import org.iitbact.erp.repository.PatientRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.PatientRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.PatientLiveStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServices {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientLiveStatusRepository patientLiveStatusRepository;

	@Autowired
	private ApiValidationService validationService;

	private void authenticateUser(String authToken) {
		validationService.verifyFirebaseIdToken(authToken);
	}

	public BooleanResponse addPatient(PatientRequestBean request) {
		this.authenticateUser(request.getAuthToken());

		if (request.getData() != null) {
			patientRepository.save(request.getData());
		}

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public List<Patient> searchPatientByName(String name, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientRepository.findByNameContaining(name);
	}

	public BooleanResponse updatePatientDetails(PatientRequestBean request) {
		this.authenticateUser(request.getAuthToken());
		Patient entity = patientRepository.findById(request.getData().getPatientId()).get();
		if (entity != null) {
			entity.updatePatient(request.getData());
			patientRepository.save(entity);
		}

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public PatientLiveStatusResponse fetchPatientStatusLive(int patientId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());

		PatientLiveStatusInterface patientStatus = patientLiveStatusRepository.findByPatientId(patientId);
		PatientLiveStatusResponse response = new PatientLiveStatusResponse();
		response.setPatientStatus(patientStatus);

		return response;
	}
}
