package org.iitbact.erp.requests;

import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;

public class PatientTransferRequestBean extends BaseRequest {
	private int facilityId;
	
	private SEVERITY patientCondition;

	private int patientId;

	private TEST_STATUS testOutcome;

	private int wardId;

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public SEVERITY getPatientCondition() {
		return patientCondition;
	}

	public void setPatientCondition(SEVERITY patientCondition) {
		this.patientCondition = patientCondition;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public TEST_STATUS getTestOutcome() {
		return testOutcome;
	}

	public void setTestOutcome(TEST_STATUS testOutcome) {
		this.testOutcome = testOutcome;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	
}
