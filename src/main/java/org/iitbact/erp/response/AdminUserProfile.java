package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.entities.AdminUser;

public class AdminUserProfile implements BaseBean {

	private AdminUser profile;


	public AdminUser getProfile() {
		return profile;
	}


	public void setProfile(AdminUser profile) {
		this.profile = profile;
	}
	
}
