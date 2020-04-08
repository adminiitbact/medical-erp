package org.iitbact.erp.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;


/**
 * The persistent class for the hospital_users database table.
 * 
 */
@Entity
@Table(name="hospital_users")
@NamedQuery(name="HospitalUser.findAll", query="SELECT h FROM HospitalUser h")
@JsonIgnoreProperties("facility")
public class HospitalUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="creation_time")
	private Timestamp creationTime;

	@Column(name="email_id")
	private String emailId;

	@Id
	private int id;

	private String name;

	private String role;

	@Column(name="user_id")
	private String userId;

	//uni-directional many-to-one association to Facility
	@ManyToOne
	@JoinColumn(name="facility_id", referencedColumnName="facility_id")
	private Facility facility;

	public HospitalUser() {
	}

	public Timestamp getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Facility getFacility() {
		return this.facility;
	}

	public void setFacility(Facility facility) {
		this.facility = facility;
	}

}