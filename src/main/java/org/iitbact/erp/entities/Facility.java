package org.iitbact.erp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the facilities database table.
 * 
 */
@Entity
@Table(name="facilities")
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	private String area;

	@Column(name="creation_time")
	private Timestamp creationTime;

	private String email;

	@Id
	@Column(name="facility_id")
	private int facilityId;

	@Column(name="facility_type")
	private String facilityType;

	@Column(name="government_hospital")
	private byte governmentHospital;

	private String jurisdiction;

	private String name;

	private String telephone;

	public Facility() {
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public byte getGovernmentHospital() {
		return this.governmentHospital;
	}

	public void setGovernmentHospital(byte governmentHospital) {
		this.governmentHospital = governmentHospital;
	}

	public String getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}