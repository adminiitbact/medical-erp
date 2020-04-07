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

	@Column(name="ambulance_incharge")
	private String ambulanceIncharge;

	@Column(name="ambulance_incharge_mob_no")
	private String ambulanceInchargeMobNo;

	private String area;

	@Column(name="cleaning_incharge")
	private String cleaningIncharge;

	@Column(name="cleaning_incharge_mob_no")
	private String cleaningInchargeMobNo;

	@Column(name="contact_person")
	private String contactPerson;

	@Column(name="contact_person_mob_no")
	private String contactPersonMobNo;

	@Column(name="creation_time")
	private Timestamp creationTime;

	@Id
	@Column(name="facility_id")
	private int facilityId;

	@Column(name="facility_type")
	private String facilityType;

	@Column(name="health_checkup_incharge")
	private String healthCheckupIncharge;

	@Column(name="health_checkup_incharge_mob_no")
	private String healthCheckupInchargeMobNo;

	private String jurisdiction;

	@Column(name="modification_time")
	private Timestamp modificationTime;

	private String name;

	@Column(name="organisation_email")
	private String organisationEmail;

	@Column(name="organisation_telephone")
	private String organisationTelephone;

	public Facility() {
	}

	public String getAmbulanceIncharge() {
		return this.ambulanceIncharge;
	}

	public void setAmbulanceIncharge(String ambulanceIncharge) {
		this.ambulanceIncharge = ambulanceIncharge;
	}

	public String getAmbulanceInchargeMobNo() {
		return this.ambulanceInchargeMobNo;
	}

	public void setAmbulanceInchargeMobNo(String ambulanceInchargeMobNo) {
		this.ambulanceInchargeMobNo = ambulanceInchargeMobNo;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCleaningIncharge() {
		return this.cleaningIncharge;
	}

	public void setCleaningIncharge(String cleaningIncharge) {
		this.cleaningIncharge = cleaningIncharge;
	}

	public String getCleaningInchargeMobNo() {
		return this.cleaningInchargeMobNo;
	}

	public void setCleaningInchargeMobNo(String cleaningInchargeMobNo) {
		this.cleaningInchargeMobNo = cleaningInchargeMobNo;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPersonMobNo() {
		return this.contactPersonMobNo;
	}

	public void setContactPersonMobNo(String contactPersonMobNo) {
		this.contactPersonMobNo = contactPersonMobNo;
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
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

	public String getHealthCheckupIncharge() {
		return this.healthCheckupIncharge;
	}

	public void setHealthCheckupIncharge(String healthCheckupIncharge) {
		this.healthCheckupIncharge = healthCheckupIncharge;
	}

	public String getHealthCheckupInchargeMobNo() {
		return this.healthCheckupInchargeMobNo;
	}

	public void setHealthCheckupInchargeMobNo(String healthCheckupInchargeMobNo) {
		this.healthCheckupInchargeMobNo = healthCheckupInchargeMobNo;
	}

	public String getJurisdiction() {
		return this.jurisdiction;
	}

	public void setJurisdiction(String jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public Timestamp getModificationTime() {
		return this.modificationTime;
	}

	public void setModificationTime(Timestamp modificationTime) {
		this.modificationTime = modificationTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganisationEmail() {
		return this.organisationEmail;
	}

	public void setOrganisationEmail(String organisationEmail) {
		this.organisationEmail = organisationEmail;
	}

	public String getOrganisationTelephone() {
		return this.organisationTelephone;
	}

	public void setOrganisationTelephone(String organisationTelephone) {
		this.organisationTelephone = organisationTelephone;
	}

}