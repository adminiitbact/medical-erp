package org.iitbact.erp.requests;

import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;

public class FacilityRequest extends BaseRequest {
	private int facilityId;
	private TEST_STATUS testStatus;
	private SEVERITY severity;

	public TEST_STATUS getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(TEST_STATUS testStatus) {
		this.testStatus = testStatus;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

}
