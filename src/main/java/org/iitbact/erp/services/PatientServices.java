package org.iitbact.erp.services;

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
import org.iitbact.erp.requests.PostPatientRequestBean;
import org.iitbact.erp.requests.PatientTransferRequestBean;
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
	public BooleanResponse addPatient(PostPatientRequestBean request) {
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
			changeWardAvailablility(request.getWardId(), -1);
		}
		
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public PatientLiveStatusResponse fetchPatientStatusLive(int patientId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		PatientLiveStatusInterface patientStatus = patientLiveStatusRepository.findByPatientIdFromMultipleTables(patientId);
		PatientLiveStatusResponse response = new PatientLiveStatusResponse();
		response.setPatientStatus(patientStatus);
		return response;
	}

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

	@Transactional
	public BooleanResponse patientStatusUpdate(int patientId, PatientTransferRequestBean request) {
		this.authenticateUser(request.getAuthToken());
		
		PatientLiveStatus patientCurrentStatus = patientLiveStatusRepository
				.findByPatientId(patientId);

		int requestWardId = request.getWardId();
		int currentWardId = patientCurrentStatus.getWardId();
		int requestFacilityId = request.getFacilityId();
		
		//Synchronus TODO
		if (requestWardId != currentWardId) {
			if (requestWardId != 0) {
				if(currentWardId!=0){
					changeWardAvailablility(currentWardId, 1);
				}
				changeWardAvailablility(requestWardId, -1);
			} 
			else {
				if(currentWardId!=0){
					changeWardAvailablility(currentWardId, 1);
				}
			}
		}

		if (requestFacilityId != 0) {
			PatientHistory history = new PatientHistory(patientId,request);
			patientHistoryRepository.save(history);
			PatientLiveStatus patientLiveStatus =  patientLiveStatusRepository.findByPatientId(patientId);
			patientLiveStatus.update(patientId,request);
			patientLiveStatusRepository.save(patientLiveStatus);
		}

	
		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	private boolean changeWardAvailablility(int id, int value) {
		Ward ward = wardRepo.getOne(id);
		if (value == 1) {
			ward.IncreaseAvailabilityByOne();
		} else {
			ward.decreaseAvailabilityByOne();
		}
		wardRepo.save(ward);
		return true;
	}
}
