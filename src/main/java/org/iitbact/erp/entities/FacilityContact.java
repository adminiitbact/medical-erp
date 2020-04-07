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
 * The persistent class for the facility_contacts database table.
 * 
 */
@Entity
@Table(name="facility_contacts")
@NamedQuery(name="FacilityContact.findAll", query="SELECT f FROM FacilityContact f")
public class FacilityContact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="facility_id")
	private String facilityId;

	private String data;

	//bi-directional one-to-one association to Facility
	@OneToOne
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	private Facility facility;

	public FacilityContact() {
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