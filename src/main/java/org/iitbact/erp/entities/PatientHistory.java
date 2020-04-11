package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.iitbact.erp.beans.BaseBean;


/**
 * The persistent class for the patient_history database table.
 * 
 */
@Entity
@Table(name="patient_history")
@NamedQuery(name="PatientHistory.findAll", query="SELECT p FROM PatientHistory p")
public class PatientHistory implements Serializable,BaseBean {
	private static final long serialVersionUID = 1L;

	private String condition;

	@Column(name="facility_id")
	private int facilityId;

	@Id
	private int id;

	@Column(name="test_outcome")
	private String testOutcome;

	@Column(name="ward_id")
	private int wardId;

	@Column(name="patient_id")
	private int patientId;
	
	public PatientHistory() {
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
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

	public String getTestOutcome() {
		return this.testOutcome;
	}

	public void setTestOutcome(String testOutcome) {
		this.testOutcome = testOutcome;
	}

	public int getWardId() {
		return this.wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
}