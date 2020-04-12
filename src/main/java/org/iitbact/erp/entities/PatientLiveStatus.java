package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.iitbact.erp.requests.PatientRequestBean;
import org.iitbact.erp.requests.PatientTransferRequestBean;


/**
 * The persistent class for the patient_live_status database table.
 * 
 */
@Entity
@Table(name="patient_live_status")
public class PatientLiveStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="facility_id")
	private int facilityId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="patient_condition")
	private String patientCondition;

	@Column(name="patient_id")
	private int patientId;

	@Column(name="test_outcome")
	private String testOutcome;

	@Column(name="ward_id")
	private int wardId;

	public PatientLiveStatus() {
	}
	
	public PatientLiveStatus(PatientRequestBean request,Patient patient) {
		this.facilityId=request.getFacilityId();
		this.wardId=request.getWardId();
		this.patientId=patient.getPatientId();
		this.testOutcome=request.getTestOutcome().toString();
		this.patientCondition=request.getSeverity().toString();
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

	public String getPatientCondition() {
		return this.patientCondition;
	}

	public void setPatientCondition(String patientCondition) {
		this.patientCondition = patientCondition;
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

	public void update(PatientTransferRequestBean request) {
		this.patientCondition=request.getPatientCondition().toString();
		this.facilityId=request.getFacilityId();
		this.wardId=request.getWardId();
		this.patientId=request.getPatientId();
		this.testOutcome=request.getTestOutcome().toString();
	}
}