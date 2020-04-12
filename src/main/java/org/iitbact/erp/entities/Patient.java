package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PatientRequestBean;

@Entity
@Table(name = "patients")
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String address;

	private int age;

	@Column(name = "contact_number")
	private String contactNumber;

	private String gender;

	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int patientId;
	
	@Column(name = "emergency_contact")
	private String emergencyContact;

	public Patient() {
	}

	public Patient(PatientRequestBean request) {
		this.setAddress(request.getAddress());
		this.setAge(request.getAge());
		this.setContactNumber(request.getContactNumber());
		this.setGender(request.getGender());
		this.setName(request.getName());
		this.setEmergencyContact(request.getEmergencyContact());
	}

	public void updatePatient(PatientProfileRequestBean request) {
		this.setAddress(request.getAddress());
		this.setAge(request.getAge());
		this.setContactNumber(request.getContactNumber());
		this.setGender(request.getGender());
		this.setName(request.getName());
		this.setEmergencyContact(request.getEmergencyContact());
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

}