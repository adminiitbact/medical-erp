package org.iitbact.erp.requests;

import org.iitbact.erp.entities.Patient;

public class PatientRequestBean extends BaseRequest {
	Patient data;

	public Patient getData() {
		return data;
	}

	public void setData(Patient data) {
		this.data = data;
	}
	
}
