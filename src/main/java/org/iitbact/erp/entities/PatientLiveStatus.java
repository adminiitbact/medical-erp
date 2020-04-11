package org.iitbact.erp.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the patient_live_status database table.
 * 
 */
@Entity
@Table(name="patient_live_status")
@NamedQuery(name="PatientLiveStatus.findAll", query="SELECT p FROM PatientLiveStatus p")
public class PatientLiveStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	private String condition;

	@Column(name="facility_id")
	private int facilityId;

	@Id
	private int id;

	@Column(name="patient_id")
	private int patientId;

	@Column(name="test_outcome")
	private String testOutcome;

	@Column(name="ward_id")
	private int wardId;

	public PatientLiveStatus() {
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

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

}