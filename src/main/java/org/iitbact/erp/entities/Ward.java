package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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

	@Column(name="facility_id")
	private int facilityId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name="total_beds")
	private int totalBeds;

	private String type;

	public Ward() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void decreaseAvailabilityByOne() {
		this.availableBeds-=1;
	}
	public void IncreaseAvailabilityByOne() {
		this.availableBeds+=1;
	}
	
	
}