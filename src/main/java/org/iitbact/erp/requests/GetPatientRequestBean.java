package org.iitbact.erp.requests;

public class GetPatientRequestBean extends BaseRequest {
	boolean referred;

	public boolean isReferred() {
		return referred;
	}

	public void setReferred(boolean referred) {
		this.referred = referred;
	}
	
}
