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
@Table(name = "wards_history")
@NamedQuery(name = "WardsHistory.findAll", query = "SELECT w FROM WardsHistory w")
public class WardsHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "available_beds")
	private int availableBeds;

	@Column(name = "facility_id")
	private int facilityId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ward_id")
	private int WardId;

	private String name;

	@Column(name = "total_beds")
	private int totalBeds;

	@Column(name = "covid_status")
	private String covidStatus;

	@Column(name = "severity")
	private String severity;

	@Column(name = "icu_beds")
	private int icuBeds;

	@Column(name = "ventilators")
	private int ventilators;

	private String gender;

	@Column(name = "beds_distance_6_feet")
	private boolean bedsDestance6Feet;

	@Column(name = "covid_ward")
	private boolean covidWard;

	@Column(name = "independent_room_with_bed_and_toilet")
	private boolean independentRoomsWithBedAndToilet;

	public WardsHistory() {
	}


	public WardsHistory(Ward request) {
		this.setAvailableBeds(request.getAvailableBeds());
		this.setFacilityId(request.getFacilityId());
		this.setName(request.getName());
		this.setTotalBeds(request.getTotalBeds());
		this.setWardId(request.getId());
		this.setCovidStatus(request.getCovidStatus());
		this.setSeverity(request.getSeverity());
		this.setIcuBeds(request.getIcuBeds());
		this.setVentilators(request.getVentilators());
		this.setGender(request.getGender());
		this.setBedsDestance6Feet(request.isBedsDestance6Feet());
		this.setCovidWard(request.isCovidWard());
		this.setIndependentRoomsWithBedAndToilet(request.isIndependentRoomsWithBedAndToilet());
	}

	public int getAvailableBeds() {
		return this.availableBeds;
	}

	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}

	public int getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getId() {
		return this.id;
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

	public int getTotalBeds() {
		return this.totalBeds;
	}

	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}

	public void decreaseAvailabilityByOne() {
		this.availableBeds -= 1;
	}

	public void IncreaseAvailabilityByOne() {
		this.availableBeds += 1;
	}

	public String getCovidStatus() {
		return covidStatus;
	}

	public void setCovidStatus(String covidStatus) {
		this.covidStatus = covidStatus;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public int getIcuBeds() {
		return icuBeds;
	}

	public void setIcuBeds(int icuBeds) {
		this.icuBeds = icuBeds;
	}

	public int getVentilators() {
		return ventilators;
	}

	public void setVentilators(int ventilators) {
		this.ventilators = ventilators;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isBedsDestance6Feet() {
		return bedsDestance6Feet;
	}

	public void setBedsDestance6Feet(boolean bedsDestance6Feet) {
		this.bedsDestance6Feet = bedsDestance6Feet;
	}

	public boolean isCovidWard() {
		return covidWard;
	}

	public void setCovidWard(boolean covidWard) {
		this.covidWard = covidWard;
	}

	public boolean isIndependentRoomsWithBedAndToilet() {
		return independentRoomsWithBedAndToilet;
	}

	public void setIndependentRoomsWithBedAndToilet(boolean independentRoomsWithBedAndToilet) {
		this.independentRoomsWithBedAndToilet = independentRoomsWithBedAndToilet;
	}

	public int getWardId() {
		return WardId;
	}

	public void setWardId(int wardId) {
		WardId = wardId;
	}

}