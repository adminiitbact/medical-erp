package org.iitbact.erp.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facility_assets database table.
 * 
 */
@Entity
@Table(name="facility_assets")
@NamedQuery(name="FacilityAsset.findAll", query="SELECT f FROM FacilityAsset f")
public class FacilityAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACILITY_ASSETS_FACILITYID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACILITY_ASSETS_FACILITYID_GENERATOR")
	@Column(name="facility_id")
	private int facilityId;

	private Object data;

	//bi-directional one-to-one association to Facility
	@OneToOne
	private Facility facility;

	public FacilityAsset() {
	}

	public int getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
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

}