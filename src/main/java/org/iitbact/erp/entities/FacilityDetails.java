package org.iitbact.erp.entities;

public interface FacilityDetails {
	public int getFacilityId();
	public String getName();
	public String getArea();
	public String getJurisdiction();
	public String getInstitutionType();
	public String getCovidFacilityType();
	public String getTelephone();
	public int getAvailability();
	public boolean isMapped();
}
