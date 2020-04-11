package org.iitbact.erp.requests;

import org.iitbact.erp.entities.PatientLiveStatus;

public class PatientTransferRequestBean extends BaseRequest {
	PatientLiveStatus data;

	public PatientLiveStatus getData() {
		return data;
	}

	public void setData(PatientLiveStatus data) {
		this.data = data;
	}

}
