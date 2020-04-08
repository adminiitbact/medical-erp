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
	
	@Id
	@Column(name="facility_id")
	private int facilityId;
	
	@Column(name="creation_time")
	private Timestamp creationTime;

	private String email;

	@Column(name="facility_type")
	private String facilityType;

	@Column(name="government_hospital")
	private Byte governmentHospital;

	private String jurisdiction;

	private String name;

	private String telephone;

	//bi-directional one-to-one association to FacilityAsset
	@OneToOne(mappedBy="facility", cascade = {CascadeType.ALL})
	private FacilityAsset facilityAsset;

	//bi-directional one-to-one association to FacilityChecklist
	@OneToOne(mappedBy="facility", cascade = {CascadeType.ALL})
	private FacilityChecklist facilityChecklist;

	//bi-directional one-to-one association to FacilityContact
	@OneToOne(mappedBy="facility", cascade = {CascadeType.ALL})
	private FacilityContact facilityContact;

	//bi-directional one-to-one association to FacilityInventory
	@OneToOne(mappedBy="facility", cascade = {CascadeType.ALL})
	private FacilityInventory facilityInventory;

	//bi-directional one-to-one association to FacilityMedstaff
	@OneToOne(mappedBy="facility", cascade = {CascadeType.ALL})
	private FacilityMedstaff facilityMedstaff;

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

	public String getFacilityType() {
		return this.facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public Byte getGovernmentHospital() {
		return this.governmentHospital;
	}

	public void setGovernmentHospital(Byte governmentHospital) {
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

	public FacilityAsset getFacilityAsset() {
		if(this.facilityAsset == null) {
			this.facilityAsset = new FacilityAsset(this);
		}
		return this.facilityAsset;
	}

	public void setFacilityAsset(FacilityAsset facilityAsset) {
		this.facilityAsset = facilityAsset;
	}

	public FacilityChecklist getFacilityChecklist() {
		if(this.facilityChecklist == null) {
			this.facilityChecklist = new FacilityChecklist(this);
		}
		return this.facilityChecklist;
	}

	public void setFacilityChecklist(FacilityChecklist facilityChecklist) {
		this.facilityChecklist = facilityChecklist;
	}

	public FacilityContact getFacilityContact() {
		if(this.facilityContact == null) {
			this.facilityContact = new FacilityContact(this);
		}
		return this.facilityContact;
	}

	public void setFacilityContact(FacilityContact facilityContact) {
		this.facilityContact = facilityContact;
	}

	public FacilityInventory getFacilityInventory() {
		if(this.facilityInventory == null) {
			this.facilityInventory = new FacilityInventory(this);
		}
		return this.facilityInventory;
	}

	public void setFacilityInventory(FacilityInventory facilityInventory) {
		this.facilityInventory = facilityInventory;
	}

	public FacilityMedstaff getFacilityMedstaff() {
		if(this.facilityMedstaff == null) {
			this.facilityMedstaff = new FacilityMedstaff(this);
		}
		return this.facilityMedstaff;
	}

	public void setFacilityMedstaff(FacilityMedstaff facilityMedstaff) {
		this.facilityMedstaff = facilityMedstaff;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

}