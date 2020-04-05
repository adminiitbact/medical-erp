package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.entities.HospitalUser;

public class ErpUserProfile implements BaseBean {

	private HospitalUser profile;


	public HospitalUser getProfile() {
		return profile;
	}


	public void setProfile(HospitalUser profile) {
		this.profile = profile;
	}
	
}
