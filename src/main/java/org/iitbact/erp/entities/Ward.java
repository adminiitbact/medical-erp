package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "wards")
public class Ward implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Id
	private int id;

	@Column(name = "facility_id", insertable = false, updatable = false)
	private int facilityId;
	private String name;
	private String type;
	@Column(name = "total_beds")
	private int totalBeds;
	@Column(name = "available_beds")
	private int availableBeds;
	
	//uni-directional many-to-one association to Facility
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	private Facility facility;

	
	public Ward() {
	}
	
	

	public Ward(Facility facility) {
		this.setFacility(facility);
		this.setFacilityId(facility.getFacilityId());
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}

	public int getAvailableBeds() {
		return availableBeds;
	}

	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Facility getFacility() {
		return facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}
