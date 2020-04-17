package org.iitbact.erp.requests;

import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;

public class PatientTransferRequestBean extends BaseRequest {
	private int facilityId;
	
	private String patientHospitalId;
	
	private SEVERITY severity;

	private TEST_STATUS testStatus;

	private int wardId;

	
	public String getPatientHospitalId() {
		return patientHospitalId;
	}

	public void setPatientHospitalId(String patientHospitalId) {
		this.patientHospitalId = patientHospitalId;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public TEST_STATUS getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(TEST_STATUS testStatus) {
		this.testStatus = testStatus;
	}

	
}
