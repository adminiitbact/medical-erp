package org.iitbact.erp.services;

import java.util.List;

import org.iitbact.erp.constants.CovidStatus;
import org.iitbact.erp.constants.TEST_STATUS;
import org.iitbact.erp.entities.Ward;
import org.iitbact.erp.entities.WardsHistory;
import org.iitbact.erp.exceptions.HospitalErpErrorCode;
import org.iitbact.erp.exceptions.HospitalErpErrorMsg;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.repository.WardHistoryRepository;
import org.iitbact.erp.repository.WardRepository;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.requests.FacilityRequest;
import org.iitbact.erp.requests.WardRequestBean;
import org.iitbact.erp.response.BooleanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WardServices {

	@Autowired
	private WardRepository wardRepository;

	@Autowired
	private WardHistoryRepository wardHistoryRepository;

	@Autowired
	private ApiValidationService validationService;

	public Ward findWardByIdAndFacilityId(int wardId, int facilityId) {
		try {
			Ward ward = wardRepository.findByIdAndFacilityId(wardId, facilityId);
			if (ward == null) {
				System.out.println("Ward not found {findWardByIdAndFacilityId} wardId : " + wardId + " facilityId : "
						+ facilityId);
				throw new HospitalErpException(HospitalErpErrorCode.INVALID_INPUT, HospitalErpErrorMsg.INVALID_INPUT);
			}
			return ward;
		} catch (Exception e) {
			System.out.println(
					"System Error {findWardByIdAndFacilityId} Ward : " + wardId + " facilityId : " + facilityId);
			throw new HospitalErpException(HospitalErpErrorCode.DATABASE_ERROR, HospitalErpErrorMsg.DATABASE_ERROR);
		}
	};

	@Transactional
	public void saveWard(Ward ward) {
		try {
			wardRepository.save(ward);
			wardHistoryRepository.save(new WardsHistory(ward));
		} catch (Exception e) {
			System.out.println("System Error {saveWard} :  facilityId : " + ward.getFacilityId());
			//TODO remove extra msg after discussing with team on unique constraint
			throw new HospitalErpException(HospitalErpErrorCode.DATABASE_ERROR, HospitalErpErrorMsg.DATABASE_ERROR + " Also cross check the wardname/floor/building for duplicacy!");
		}
	}

	public List<Ward> fetchAvailableWards(int facilityId, FacilityRequest request) {

		validationService.fetchAvailableWards(facilityId, request);

		String covidStatus = getCovidStatus(request.getTestStatus().toString());

		try {
			return wardRepository.findByFacilityIdAndCovidStatusAndSeverity(facilityId, covidStatus,
					request.getSeverity().toString());
		} catch (Exception e) {
			System.out.println("System Error {fetchAvailableWards} :  facilityId : " + facilityId);
			throw new HospitalErpException(HospitalErpErrorCode.DATABASE_ERROR, HospitalErpErrorMsg.DATABASE_ERROR);
		}
	}

	public BooleanResponse addAndUpdateWards(int facilityId, WardRequestBean request) {

		Ward ward = validationService.addAndUpdateWards(facilityId, request);

		// Ward already exist , update the existing ward
		if (ward != null) {
			ward.updateWard(request);
		} else {
			ward = new Ward(request, facilityId);
		}
		
		saveWard(ward);

		BooleanResponse returnVal = new BooleanResponse(true);
		return returnVal;
	}

	public BooleanResponse removeWard(int facilityId, int wardId,BaseRequest request) {
		
		Ward ward = validationService.removeWard(facilityId,wardId,request);
		
		ward.setActive(false);
		
		saveWard(ward);
		
		return new BooleanResponse(true);
	}

	// ######################### Private methods #########################
	private String getCovidStatus(String testStatus) {
		if (TEST_STATUS.POSITIVE.toString().equalsIgnoreCase(testStatus)) {
			return CovidStatus.CONFIRMED.toString();
		} else {
			return CovidStatus.SUSPECTED.toString();
		}
	}
}
