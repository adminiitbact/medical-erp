package org.iitbact.erp.response;

import org.iitbact.erp.beans.BaseBean;

public interface MappedAdminFacilityResponse extends BaseBean {
	public int getFacilityId();

	public String getName();

	public String getArea();

	public String getJurisdiction();

	public String getFacilityType();

	public String getCovidFacilityType();

	public String getGovernmentHospital();

	public boolean isMapped();

}
