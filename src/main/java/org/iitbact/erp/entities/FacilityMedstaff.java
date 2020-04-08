package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.iitbact.erp.beans.BaseBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the facility_medstaff database table.
 * 
 */
@Entity
@Table(name="facility_medstaff")
@NamedQuery(name="FacilityMedstaff.findAll", query="SELECT f FROM FacilityMedstaff f")
@JsonIgnoreProperties("facility")
public class FacilityMedstaff implements Serializable, BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="facility_id")
	private int facilityId;
	
	@Type(type = "json")
    @Column(columnDefinition = "json")
	private Object data;

	//bi-directional one-to-one association to Facility
	@OneToOne
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	private Facility facility;

	public FacilityMedstaff() {
	}
	public FacilityMedstaff(Facility facility) {
		this.setFacility(facility);
		this.setFacilityId(facility.getFacilityId());
	}
	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
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