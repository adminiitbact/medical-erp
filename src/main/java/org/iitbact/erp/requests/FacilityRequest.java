package org.iitbact.erp.requests;

public class FacilityRequest extends BaseRequest {
	private String testStatus;
	private String severity;
	
	
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
}
