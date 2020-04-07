package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the facility_inventory database table.
 * 
 */
@Entity
@Table(name="facility_inventory")
@NamedQuery(name="FacilityInventory.findAll", query="SELECT f FROM FacilityInventory f")
public class FacilityInventory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="facility_id")
	private int facilityId;

	private String data;

	//uni-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	private Facility facility;

	public FacilityInventory() {
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


	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

}