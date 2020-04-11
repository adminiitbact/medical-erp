package org.iitbact.erp.services;

import java.util.List;

import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientHistory;
import org.iitbact.erp.repository.PatientHistoryRepository;
import org.iitbact.erp.repository.PatientRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.PatientRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServices {

	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired 
	private PatientHistoryRepository patientHistoryRepository;
	
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

	public List<Patient> searchPatientByName(String name,BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
				return patientRepository.findByName(name);
	}

	public Patient getPatientDetails(int id,BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientRepository.findById(id);
	}

	public BooleanResponse updatePatientDetails(PatientRequestBean request) {
		this.authenticateUser(request.getAuthToken());
		Patient entity = patientRepository.findById(request.getData().getPatientId());
		if(entity!=null){
			entity.updatePatient(request.getData());
			patientRepository.save(entity);
		}
		
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public PatientHistory fetchPatientStatusLive(int patientId,BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientHistoryRepository.findLatestStatus(patientId);
	}

	public List<Patient> searchPatientByFacility(int facility_id,BaseRequest request) {
	 this.authenticateUser(request.getAuthToken());
		return patientRepository.findByFacilityId(facility_id);
	}
}
