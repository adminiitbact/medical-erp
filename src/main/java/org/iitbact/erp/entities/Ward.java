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
import org.iitbact.erp.requests.WardRequestBean;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

/**
 * The persistent class for the wards database table.
 * 
 */
@Entity
@Table(name = "wards")
@NamedQuery(name = "Ward.findAll", query = "SELECT w FROM Ward w")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Ward implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "building_name")
	private String buildingName;

	@Column(name = "covid_status")
	private String covidStatus;

	@Column(name = "extra_fields", columnDefinition = "json")
	@Type(type = "json")
	private Object extraFields;

	@Column(name = "facility_id")
	private int facilityId;

	private String floor;

	private String gender;

	@Column(name="covid_ward")
	private boolean covidWard;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String name;

	private String severity;

	@Column(name = "total_beds")
	private int totalBeds;
	
	@Column(name = "available_beds")
	private int availableBeds;
	

	private int ventilators;
	
	@Column(name="ventilators_occupied")
	private int ventilatorsOccupied;
	
	private boolean active;

	public Ward() {
	}

	public Ward(WardRequestBean request, int facilityId2) {
		this.setAvailableBeds(request.getTotalBeds());
		this.setTotalBeds(request.getTotalBeds());
		this.setCovidStatus(request.getCovidStatus().toString());
		this.setSeverity(request.getSeverity().toString());
		this.setVentilators(request.getVentilators());
		this.setFloor(request.getFloor());
		this.setName(request.getName());
		this.setGender(request.getGender().toString());
		this.setBuildingName(request.getBuildingName());
		this.setExtraFields(request.getExtraFields());
		this.setFacilityId(facilityId2);
		this.setCovidWard(request.isCovidWard());
		this.setVentilatorsOccupied(request.getVentilatorsOccupied());
		this.setActive(true);
	}
	
	public void updateWard(WardRequestBean request) {
		int newAvailablity=this.availableBeds+(request.getTotalBeds()-this.totalBeds);
		this.setAvailableBeds(newAvailablity);
		
		this.setTotalBeds(request.getTotalBeds());
		
		this.setCovidStatus(request.getCovidStatus().toString());
		this.setSeverity(request.getSeverity().toString());
		
		//Unique constraint//TODO we should remove this as delete feature is up
		this.floor = request.getFloor();
		this.setName(request.getName());
		this.setBuildingName(request.getBuildingName());
		
		this.setGender(request.getGender().toString());
		
		this.covidWard=request.isCovidWard();
		this.setExtraFields(request.getExtraFields());
		this.setVentilatorsOccupied(request.getVentilatorsOccupied());
		this.setVentilators(request.getVentilators());
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getVentilatorsOccupied() {
		return ventilatorsOccupied;
	}

	public void setVentilatorsOccupied(int ventilatorsOccupied) {
		this.ventilatorsOccupied = ventilatorsOccupied;
	}

	public boolean isCovidWard() {
		return covidWard;
	}

	public void setCovidWard(boolean covidWard) {
		this.covidWard = covidWard;
	}

	public int getAvailableBeds() {
		return availableBeds;
	}

	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}