package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.entities.Patient;

public class PatientResponse implements BaseBean{

		private Patient patientDetails;

		public Patient getPatientDetails() {
			return patientDetails;
		}

		public void setPatientDetails(Patient patientDetails) {
			this.patientDetails = patientDetails;
		}
}
