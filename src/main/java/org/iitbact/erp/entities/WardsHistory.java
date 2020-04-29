package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonStringType;


/**
 * The persistent class for the wards_history database table.
 * 
 */
@Entity
@Table(name="wards_history")
@NamedQuery(name="WardsHistory.findAll", query="SELECT w FROM WardsHistory w")
@TypeDef(
	    name = "json",
	    typeClass = JsonStringType.class
	)

public class WardsHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="available_beds")
	private int availableBeds;

	@Column(name="building_name")
	private String buildingName;

	@Column(name="covid_status")
	private String covidStatus;

	@Column(name="extra_fields",columnDefinition = "json")
	@Type(type = "json")
	private Object extraFields;

	@Column(name="facility_id")
	private int facilityId;

	private String floor;

	private String gender;

	private String name;

	private String severity;

	@Column(name="total_beds")
	private int totalBeds;

	private int ventilators;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ward_history_id")
	private int wardHistoryId;

	@Column(name="ward_id")
	private int wardId;

	@Column(name="covid_ward")
	private boolean covidWard;
	
	@Column(name="ventilators_occupied")
	private int ventilatorsOccupied;
	
	private boolean active;

	public WardsHistory() {
	}

	public WardsHistory(Ward ward) {
		this.setAvailableBeds(ward.getTotalBeds());
		this.setTotalBeds(ward.getTotalBeds());
		this.setCovidStatus(ward.getCovidStatus());
		this.setSeverity(ward.getSeverity());
		this.setVentilators(ward.getVentilators());
		this.setVentilatorsOccupied(ward.getVentilatorsOccupied());
		this.setCovidWard(ward.isCovidWard());
		this.setFloor(ward.getFloor());
		this.setName(ward.getName());
		this.setGender(ward.getGender());
		this.setBuildingName(ward.getBuildingName());
		this.setExtraFields(ward.getExtraFields());
		this.setWardId(ward.getId());
		this.setFacilityId(ward.getFacilityId());
		this.setActive(ward.isActive());
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

	public int getWardHistoryId() {
		return this.wardHistoryId;
	}

	public void setWardHistoryId(int wardHistoryId) {
		this.wardHistoryId = wardHistoryId;
	}

	public int getWardId() {
		return this.wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public boolean isCovidWard() {
		return covidWard;
	}

	public void setCovidWard(boolean covidWard) {
		this.covidWard = covidWard;
	}

	public int getVentilatorsOccupied() {
		return ventilatorsOccupied;
	}

	public void setVentilatorsOccupied(int ventilatorsOccupied) {
		this.ventilatorsOccupied = ventilatorsOccupied;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}