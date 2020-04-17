package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.iitbact.erp.requests.WardRequestBean;


/**
 * The persistent class for the wards database table.
 * 
 */
@Entity
@Table(name="wards")
@NamedQuery(name="Ward.findAll", query="SELECT w FROM Ward w")
public class Ward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="available_beds")
	private int availableBeds;

	@Column(name="building_name")
	private String buildingName;

	@Column(name="covid_status")
	private String covidStatus;

	@Column(name="extra_fields")
	private Object extraFields;

	@Column(name="facility_id")
	private int facilityId;

	private String floor;

	private String gender;

	@Column(name="icu_beds")
	private int icuBeds;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="is_covid_ward")
	private boolean isCovidWard;

	private String name;

	private String severity;

	@Column(name="total_beds")
	private int totalBeds;

	private int ventilators;

	@Column(name="ward_number")
	private String wardNumber;

	public Ward() {
	}
	
	public Ward(WardRequestBean request, int facilityId2) {
		this.setAvailableBeds(request.getTotalBeds()-request.getBedsOccupied());
		this.setTotalBeds(request.getTotalBeds());
		this.setCovidStatus(request.getPatientType().toString());
		this.setSeverity(request.getSeverity().toString());
		this.setIcuBeds(request.getIcuBeds());
		this.setVentilators(request.getVentilators());;
		
		this.setName(request.getName());
		this.setGender(request.getGender().toString());
		this.setWardNumber(request.getWardNumber());
		this.setBuildingName(request.getBuildingName());
		this.setExtraFields(request.getExtraFields());
		this.setFacilityId(facilityId2);
	}

	public int getAvailableBeds() {
		return this.availableBeds;
	}

	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getCovidStatus() {
		return this.covidStatus;
	}

	public void setCovidStatus(String covidStatus) {
		this.covidStatus = covidStatus;
	}

	public Object getExtraFields() {
		return this.extraFields;
	}

	public void setExtraFields(Object extraFields) {
		this.extraFields = extraFields;
	}

	public int getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getIcuBeds() {
		return this.icuBeds;
	}

	public void setIcuBeds(int icuBeds) {
		this.icuBeds = icuBeds;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsCovidWard() {
		return this.isCovidWard;
	}

	public void setIsCovidWard(boolean isCovidWard) {
		this.isCovidWard = isCovidWard;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeverity() {
		return this.severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int getTotalBeds() {
		return this.totalBeds;
	}

	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}

	public int getVentilators() {
		return this.ventilators;
	}

	public void setVentilators(int ventilators) {
		this.ventilators = ventilators;
	}

	public String getWardNumber() {
		return this.wardNumber;
	}

	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}

	public void updateWard(WardRequestBean request) {
		//TODO how to work out this? open due to lack of clarity
		this.setAvailableBeds(request.getTotalBeds()-request.getBedsOccupied());
		this.setTotalBeds(request.getTotalBeds());
		this.setCovidStatus(request.getPatientType().toString());
		this.setSeverity(request.getSeverity().toString());
		this.setIcuBeds(request.getIcuBeds());
		this.setVentilators(request.getVentilators());;
		
		this.setName(request.getName());
		this.setGender(request.getGender().toString());
		this.setWardNumber(request.getWardNumber());
		this.setBuildingName(request.getBuildingName());
		this.setExtraFields(request.getExtraFields());

	}

}