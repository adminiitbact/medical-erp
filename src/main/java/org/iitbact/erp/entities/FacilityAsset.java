package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.TypeDef;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;


/**
 * The persistent class for the facility_assets database table.
 * 
 */
@Entity
@Table(name="facility_assets")
@NamedQuery(name="FacilityAsset.findAll", query="SELECT f FROM FacilityAsset f")
@TypeDef(
	    typeClass = JsonBinaryType.class, 
	    defaultForType = JsonNode.class
	)
public class FacilityAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	private JsonNode data;

	@Id
	@Column(name="facility_id")
	private int facilityId;

	@Column(name="user_id")
	private String userId;

	public FacilityAsset() {
	}

	public JsonNode getData() {
		return this.data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}

	public int getFacilityId() {
		return this.facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}