package org.iitbact.erp.beans;

import org.iitbact.erp.entities.FacilityDetails;

public class FacilityProfileWithAvailablity {
	private int facilityId;
	private String facilityType;
	private String covidFacilityType;
	private String jurisdiction;
	private String area;
	private String name;
	private String telephone;
	private int availablity;
	
	public FacilityProfileWithAvailablity(FacilityDetails facility) {
		this.area=facility.getArea();
		this.availablity=facility.getAvailability();
		this.covidFacilityType=facility.getCovidFacilityType();
		this.facilityId=facility.getFacilityId();
		this.facilityType=facility.getFacilityType();
		this.jurisdiction=facility.getJurisdiction();
		this.name=facility.getName();
		this.telephone=facility.getTelephone();
	}
	public int getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getCovidFacilityType() {
		return covidFacilityType;
	}
	public void setCovidFacilityType(String covidFacilityType) {
		this.covidFacilityType = covidFacilityType;
	}
	public String getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public int getAvailablity() {
		return availablity;
	}
	public void setAvailablity(int availablity) {
		this.availablity = availablity;
	}
	
	public void substractAssigned(int totalAssigned) {
		this.availablity-=totalAssigned;
	}
}
