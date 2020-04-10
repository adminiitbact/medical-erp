package org.iitbact.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.iitbact.erp.beans.BaseBean;
import org.iitbact.erp.constants.Constants;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonNode;

@Entity
@Table(name = "patients")
public class Patient implements Serializable,BaseBean {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String gender;
	private int age;
	@Column(name = "contact_number")
	private long contactNumber;
	
	public Patient() {
	}

	public Patient(JsonNode patientdata) {
		this.setName(patientdata.get(Constants.PATIENT_NAME).asText());
		this.setGender(patientdata.get(Constants.GENDER).asText());
		this.setAge(patientdata.get(Constants.AGE).asInt());
		this.setContactNumber(patientdata.get(Constants.CONTACT_NUMBER).asLong());
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

}
