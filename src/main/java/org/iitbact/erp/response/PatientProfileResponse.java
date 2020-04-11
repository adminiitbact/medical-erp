package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.entities.Patient;

public class PatientProfileResponse implements BaseBean{

		private Patient profile;

		public Patient getProfile() {
			return profile;
		}

		public void setProfile(Patient profile) {
			this.profile = profile;
		}
}
