package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.entities.User;

public class ErpUserProfile implements BaseBean {

	private User profile;


	public User getProfile() {
		return profile;
	}


	public void setProfile(User profile) {
		this.profile = profile;
	}
	
}
