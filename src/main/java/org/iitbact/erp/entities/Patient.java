package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.iitbact.erp.beans.BaseBean;

@Entity
@Table(name = "patients")
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
public class Patient implements Serializable, BaseBean {
	private static final long serialVersionUID = 1L;

	@Lob
	private String address;

	private int age;

	@Column(name = "contact_number")
	private String contactNumber;

	private String gender;

	private String name;

	@Id
	@Column(name = "patient_id")
	private int patientId;

	public Patient() {
	}

	public void updatePatient(Patient patient) {
		this.setAddress(patient.getAddress());
		this.setAge(patient.age);
		this.setContactNumber(patient.getContactNumber());
		this.setGender(patient.getGender());
		this.setName(patient.getName());
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

}