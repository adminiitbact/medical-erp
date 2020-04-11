package org.iitbact.erp.requests;

public class AvailableFacilityRequest extends BaseRequest {
	private String testResult;
	private String severity;
	
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
}
