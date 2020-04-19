package org.iitbact.erp.services;

import java.util.List;

import org.iitbact.erp.constants.CovidStatus;
import org.iitbact.erp.constants.TEST_STATUS;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.entities.WardsHistory;
import org.iitbact.erp.repository.WardHistoryRepository;
import org.iitbact.erp.repository.WardRepository;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.WardRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WardServices {

	@Autowired
	private WardRepository wardRepository;

	@Autowired
	private WardHistoryRepository wardHistoryRepository;

	private void authenticateUser(String authToken) {
		// validationService.verifyFirebaseIdToken(authToken); //TODO
		// userRepository.findByUserId(userId);
		// TODO: If user.facilityId == facilityId or user should be able to
		// access this
		// data then continue, else throw error
		// throw runtime hospital exception
	}

	public List<Ward> fetchAvailableWards(int facilityId, FacilityRequest request) {
		this.authenticateUser(request.getAuthToken());
		String covidStatus = getCovidStatus(request.getTestStatus().toString());

		return wardRepository.findByFacilityIdAndCovidStatusAndSeverity(facilityId, covidStatus,
				request.getSeverity().toString());
	}

	private String getCovidStatus(String testStatus) {
		if (TEST_STATUS.POSITIVE.toString().equalsIgnoreCase(testStatus)) {
			return CovidStatus.CONFIRMED.toString();
		} else {
			return CovidStatus.SUSPECTED.toString();
		}
	}

	public BooleanResponse addAndUpdateWards(int facilityId, WardRequestBean request) {
		this.authenticateUser(request.getAuthToken());
		//TODO validation on total bed count against occupied beds
		
		Ward ward = null;

		if (request.getWardId() != 0) {
			ward = wardRepository.findByIdAndFacilityId(request.getWardId(), facilityId);
			ward.updateWard(request);
		} else {
			ward = new Ward(request, facilityId);
		}

		wardRepository.save(ward);
		wardHistoryRepository.save(new WardsHistory(request,facilityId,ward.getId()));

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

}
