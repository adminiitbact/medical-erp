package org.iitbact.erp.requests;

import org.iitbact.erp.constants.DISCHARGE_REASON;
import org.iitbact.erp.constants.QUARANTINE_TYPE;
import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;

public class PatientDischargedRequestBean extends BaseRequest {
	private int facilityId;
	private int wardId;
	private SEVERITY severity;
	private TEST_STATUS testStatus;
	private DISCHARGE_REASON reason;
	private QUARANTINE_TYPE quarantineType;
	private String patientHospitalId;

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

	public DISCHARGE_REASON getReason() {
		return reason;
	}

	public void setReason(DISCHARGE_REASON reason) {
		this.reason = reason;
	}

	public QUARANTINE_TYPE getQuarantineType() {
		return quarantineType;
	}

	public void setQuarantineType(QUARANTINE_TYPE quarantineType) {
		this.quarantineType = quarantineType;
	}

}
