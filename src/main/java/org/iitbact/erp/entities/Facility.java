package org.iitbact.erp.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facility database table.
 * 
 */
@Entity
@Table(name="facility")
@NamedQuery(name="Facility.findAll", query="SELECT f FROM Facility f")
public class Facility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACILITY_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACILITY_ID_GENERATOR")
	private int id;

	@Column(name="Area")
	private String area;

	@Column(name="Jurisdiction")
	private String jurisdiction;

	@Column(name="Name")
	private String name;

	//bi-directional one-to-one association to FacilityAsset
	@OneToOne(mappedBy="facility")
	private FacilityAsset facilityAsset;

	public Facility() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public FacilityAsset getFacilityAsset() {
		return this.facilityAsset;
	}

	public void setFacilityAsset(FacilityAsset facilityAsset) {
		this.facilityAsset = facilityAsset;
	}

}