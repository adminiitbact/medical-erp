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
import org.hibernate.annotations.TypeDef;
import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.requests.BaseRequest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import io.swagger.annotations.ApiModelProperty;


/**
 * The persistent class for the facility_checklist database table.
 * 
 */
@Entity
@Table(name="facility_checklist")
@TypeDef(
	    name = "json",
	    typeClass = JsonStringType.class
	)
@NamedQuery(name="FacilityChecklist.findAll", query="SELECT f FROM FacilityChecklist f")
@JsonIgnoreProperties(value= {"facility, facility_id"}, ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class FacilityChecklist extends BaseRequest implements Serializable, BaseBean {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="facility_id")
	@ApiModelProperty(hidden=true)
	private int facilityId;

    @Type(type = "json")
    @Column(columnDefinition = "json")
	private Object data;

	//bi-directional one-to-one association to Facility
	@OneToOne
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	@ApiModelProperty(hidden=true)
	private Facility facility;
	
	public FacilityChecklist() {
	}
	
	public FacilityChecklist(Facility facility) {
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