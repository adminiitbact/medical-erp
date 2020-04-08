package org.iitbact.erp.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class FacilityRequest extends FlexibleRequest {
	private String name, area, jurisdiction, facilityType, telephone, email;
	private boolean governmentHospital;
	private Object assetsData, contactsData, medStaffData, inventoryData, checklistData;

	public Object getAssetsData() {
		return assetsData;
	}

	public void setAssetsData(Object assetsData) {
		this.assetsData = assetsData;
	}

	public Object getContactsData() {
		return contactsData;
	}

	public void setContactsData(Object contactsData) {
		this.contactsData = contactsData;
	}

	public Object getMedStaffData() {
		return medStaffData;
	}

	public void setMedStaffData(Object medStaffData) {
		this.medStaffData = medStaffData;
	}

	public Object getInventoryData() {
		return inventoryData;
	}

	public void setInventoryData(Object inventoryData) {
		this.inventoryData = inventoryData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public boolean getGovernmentHospital() {
		return governmentHospital;
	}

	public void setGovernmentHospital(boolean governmentHospital) {
		this.governmentHospital = governmentHospital;
	}

	public Object getChecklistData() {
		return checklistData;
	}

	public void setChecklistData(Object checklistData) {
		this.checklistData = checklistData;
	}
}
