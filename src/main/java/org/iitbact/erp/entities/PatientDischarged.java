package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.iitbact.erp.requests.PatientDischargedRequestBean;
import org.iitbact.erp.requests.PostPatientRequestBean;

@Entity
@Table(name="patient_discharged")
@NamedQuery(name="PatientDischarged.findAll", query="SELECT p FROM PatientDischarged p")
public class PatientDischarged implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Column(name="facility_id")
	private int facilityId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="severity")
	private String severity;

	@Column(name="patient_id")
	private int patientId;

	@Column(name="test_status")
	private String testStatus;

	@Column(name="ward_id")
	private int wardId;
	
	private String reason;
	
	private String patientHospitalId;
	
	@Column(name="quarantine_type")
	private String quarantineType;

	public PatientDischarged() {
	}
	
	public PatientDischarged(PostPatientRequestBean request,Patient patient) {
		this.facilityId=request.getFacilityId();
		this.wardId=request.getWardId();
		this.patientId=patient.getPatientId();
		this.testStatus=request.getTestStatus().toString();
		this.severity=request.getSeverity().toString();
		this.patientHospitalId = request.getPatientHospitalId();
	}
	
	public PatientDischarged(int patientId, PatientDischargedRequestBean request) {
			this.patientId = patientId;
			this.facilityId = request.getFacilityId();
			this.wardId = request.getWardId();
			this.severity = request.getSeverity().toString();
			this.testStatus = request.getTestStatus().toString();
			this.reason = request.getReason().toString();
			this.quarantineType = request.getQuarantineType().toString();
			this.patientHospitalId = request.getPatientHospitalId();
		
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

	public int getWardId() {
		return this.wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getQuarantineType() {
		return quarantineType;
	}

	public void setQuarantineType(String quarantineType) {
		this.quarantineType = quarantineType;
	}

	public String getPatientHospitalId() {
		return patientHospitalId;
	}

	public void setPatientHospitalId(String patientHospitalId) {
		this.patientHospitalId = patientHospitalId;
	}


}
