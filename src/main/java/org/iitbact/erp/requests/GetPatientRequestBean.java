package org.iitbact.erp.requests;

public class GetPatientRequestBean extends BaseRequest {
	boolean wardAlloted;

	public boolean isWardAlloted() {
		return wardAlloted;
	}

	public void setWardAlloted(boolean wardAlloted) {
		this.wardAlloted = wardAlloted;
	}

}
