package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.entities.PatientLiveStatusInterface;

public class PatientLiveStatusResponse implements BaseBean {
	
	private PatientLiveStatusInterface patientStatus;

	public PatientLiveStatusInterface getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(PatientLiveStatusInterface patientStatus) {
		this.patientStatus = patientStatus;
	}
	
}
