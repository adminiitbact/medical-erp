package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the facility_medstaff database table.
 * 
 */
@Entity
@Table(name="facility_medstaff")
@NamedQuery(name="FacilityMedstaff.findAll", query="SELECT f FROM FacilityMedstaff f")
public class FacilityMedstaff implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="facility_id")
	private String facilityId;

	private String data;

	//bi-directional one-to-one association to Facility
	@OneToOne
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	private Facility facility;

	public FacilityMedstaff() {
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

}