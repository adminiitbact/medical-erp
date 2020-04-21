package org.iitbact.erp.services;

import org.iitbact.erp.entities.Patient;
import org.iitbact.erp.entities.PatientDischarged;
import org.iitbact.erp.entities.PatientHistory;
import org.iitbact.erp.entities.PatientLiveStatus;
import org.iitbact.erp.entities.PatientLiveStatusInterface;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.exceptions.HospitalErpErrorMsg;
import org.iitbact.erp.repository.PatientDischargedRepository;
import org.iitbact.erp.repository.PatientHistoryRepository;
import org.iitbact.erp.repository.PatientLiveStatusRepository;
import org.iitbact.erp.repository.PatientRepository;
import org.iitbact.erp.repository.WardRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.PatientDischargedRequestBean;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PatientTransferRequestBean;
import org.iitbact.erp.requests.PostPatientRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.iitbact.erp.response.PatientLiveStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

	@Autowired
	private PatientDischargedRepository patientDischargedRepository;

	private void authenticateUser(String authToken) {
		validationService.verifyFirebaseIdToken(authToken);
	}

	@Transactional
	public BooleanResponse addPatient(PostPatientRequestBean request) {

		// TODO validation to check if user exist wrt mobilie no. age & gender
		// (to reduce duplicate data in system)
		// TODO ward / facilily mapping check in case of ward Id is not zero
		// TODO validation facility ID ==0

		Patient patient = validationService.addPatient(request);
		patient = patientRepository.save(patient);

		// Insert into patient History & patient live status table
		PatientLiveStatus patientLiveStatus = new PatientLiveStatus(request, patient);
		PatientHistory history = new PatientHistory(request, patient);

		patientLiveStatusRepository.save(patientLiveStatus);
		patientHistoryRepository.save(history);

		// TODO Single threaded ()
		// Decrease the bed available from ward
		if (request.getWardId() != 0) {
			changeWardAvailablility(request.getWardId(), 0);
		}

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public PatientLiveStatusResponse fetchPatientStatusLive(int patientId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		PatientLiveStatusInterface patientStatus = patientLiveStatusRepository
				.findByPatientIdFromMultipleTables(patientId);
		PatientLiveStatusResponse response = new PatientLiveStatusResponse();
		response.setPatientStatus(patientStatus);
		return response;
	}

	public Patient getPatientProfile(int patientId, BaseRequest request) {
		this.authenticateUser(request.getAuthToken());
		return patientRepository.findById(patientId).get();
	}

	public Patient updatePatientProfile(int patientId, PatientProfileRequestBean request) {
		Patient profile = validationService.updatePatientProfile(patientId, request);
		profile.updatePatient(request);
		patientRepository.save(profile);
		return profile;
	}

	@Transactional
	public BooleanResponse patientStatusUpdate(int patientId, PatientTransferRequestBean request) {
		this.authenticateUser(request.getAuthToken());

		PatientLiveStatus patientCurrentStatus = patientLiveStatusRepository.findByPatientId(patientId);

		changeWardAvailablility(request.getWardId(), patientCurrentStatus.getWardId());

		patientCurrentStatus.update(patientId, request);
		if (request.getWardId() == 0) {
			patientCurrentStatus.setPatientHospitalId("NA");
		}

		PatientHistory history = new PatientHistory(patientCurrentStatus);
		patientHistoryRepository.save(history);

		patientLiveStatusRepository.save(patientCurrentStatus);

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public synchronized void changeWardAvailablility(int requestWardId, int currentWardId) {
		if (currentWardId != 0 && requestWardId != currentWardId) {
			Ward currentWard = wardRepo.getOne(currentWardId);
			increaseAvailabilityByOne(currentWard);
			wardRepo.save(currentWard);
		}

		if (requestWardId != 0 && requestWardId != currentWardId) {
			Ward newWard = wardRepo.getOne(requestWardId);
			if (newWard.getAvailableBeds() <= 0) {
				throw new HospitalErpException(HospitalErpErrorCode.NO_ENOUGH_BEDS, HospitalErpErrorMsg.NO_ENOUGH_BEDS);
			}
			decreaseAvailabilityByOne(newWard);
			wardRepo.save(newWard);
		}
		return;
	}

	private void decreaseAvailabilityByOne(Ward ward) {
		ward.setAvailableBeds(ward.getAvailableBeds() - 1);
	}

	private void increaseAvailabilityByOne(Ward ward) {
		ward.setAvailableBeds(ward.getAvailableBeds() + 1);
	}

	@Transactional
	public BooleanResponse dischargePatient(int patientId, PatientDischargedRequestBean request) {
		this.authenticateUser(request.getAuthToken());

		PatientLiveStatus patientCurrentStatus = patientLiveStatusRepository.findByPatientId(patientId);

		if (patientCurrentStatus.getWardId() != 0) {
			Ward newWard = wardRepo.getOne(patientCurrentStatus.getWardId());
			increaseAvailabilityByOne(newWard);
			wardRepo.save(newWard);
		}

		patientLiveStatusRepository.deleteById(patientCurrentStatus.getId());

		PatientHistory history = new PatientHistory(patientId, request);
		patientHistoryRepository.save(history);

		patientDischargedRepository.save(new PatientDischarged(patientId, request));

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public Patient findById(int patientId) {
		try {
			Patient patient = patientRepository.findById(patientId).get();
			if (patient == null) {
				System.out.println("Patient not found {findById} patientId : " + patientId);
				throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT, HospitalErpErrorMsg.INVALID_INPUT);
			}
			return patient;
		} catch (Exception e) {
			System.out.println("System Error {findById} PatientId : " + patientId);
			throw new HospitalErpException(HospitalErpErrorCode.DATABASE_ERROR, HospitalErpErrorMsg.DATABASE_ERROR);
		}
	}
}
