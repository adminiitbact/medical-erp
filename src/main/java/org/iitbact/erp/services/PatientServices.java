package org.iitbact.erp.services;

import java.util.List;

import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientHistory;
import org.iitbact.erp.entities.PatientLiveStatus;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.repository.PatientHistoryRepository;
import org.iitbact.erp.repository.PatientLiveStatusRepository;
import org.iitbact.erp.repository.PatientRepository;
import org.iitbact.erp.repository.WardRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PatientRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.PatientLiveStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientServices {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientLiveStatusRepository patientLiveStatusRepository;

	@Autowired
	private PatientHistoryRepository patientHistoryRepository;

	@Autowired
	private WardRepository wardRepo;

	@Autowired
	private ApiValidationService validationService;

	private void authenticateUser(String authToken) {
		validationService.verifyFirebaseIdToken(authToken);
	}

	@Transactional
	public BooleanResponse addPatient(PatientRequestBean request) {
		this.authenticateUser(request.getAuthToken());
		// TODO validation to check if user exist wrt mobilie no. age & gender
		// (to reduce duplicate data in system)
		// TODO ward / facilily mapping check in case of ward Id is not zero
		// TODO validation facility ID ==0

		Patient patient = new Patient(request);
		patient = patientRepository.save(patient);

		// Insert into patient History & patient live status table
		PatientLiveStatus patientLiveStatus = new PatientLiveStatus(request, patient);
		PatientHistory history = new PatientHistory(request, patient);

		patientLiveStatusRepository.save(patientLiveStatus);
		patientHistoryRepository.save(history);

		// TODO Single threaded ()
		// Decrease the bed available from ward
		if (request.getWardId() != 0) {
			Ward ward = wardRepo.getOne(request.getWardId());
			ward.decreaseAvailabilityByOne();
			wardRepo.save(ward);
		}
		
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public List<Patient> searchPatientByName(String name, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientRepository.findByNameContaining(name);
	}

	public PatientLiveStatusResponse fetchPatientStatusLive(int patientId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		PatientLiveStatusInterface patientStatus = patientLiveStatusRepository.findByPatientId(patientId);
		PatientLiveStatusResponse response = new PatientLiveStatusResponse();
		response.setPatientStatus(patientStatus);
		return response;
	}

	/// TODO

	public Patient getPatientProfile(int patientId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientRepository.findById(patientId).get();
	}

	public Patient updatePatientProfile(int patientId, PatientProfileRequestBean request) {
		this.authenticateUser(request.getAuthToken());
		// Validation //TODO
		Patient profile = patientRepository.findById(patientId).get();
		if (profile != null) {
			profile.updatePatient(request);
			patientRepository.save(profile);
		}
		return profile;
	}
}
