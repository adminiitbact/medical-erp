package org.iitbact.erp.requests;

import org.iitbact.erp.entities.Patient;

public class PatientRequestBean extends BaseRequest {
	Patient data;
	
	private int facilityId;
	private int wardId;
	private String testOutcome;
	private String severity;

	public Patient getData() {
		return data;
	}

	public void setData(Patient data) {
		this.data = data;
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

	public String getTestOutcome() {
		return testOutcome;
	}

	public void setTestOutcome(String testOutcome) {
		this.testOutcome = testOutcome;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
