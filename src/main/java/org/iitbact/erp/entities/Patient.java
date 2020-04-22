package org.iitbact.erp.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.iitbact.erp.constants.Constants;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PostPatientRequestBean;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "patients")
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String address;

	private String dob;

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

	@Column(name = "goi_covid_id")
	private String goiCovidId;

	@Type(type = "json")
	@Column(name = "pre_existing_medical_condition", columnDefinition = "json")
	private Object preExistingMedicalCondition;

	public Patient() {
	}
	
	public String formatDate(String date, String currentFormat, String newFormat) throws ParseException {
		return new SimpleDateFormat(currentFormat).format(new SimpleDateFormat(newFormat).parse(date));

	}
	public Patient(PostPatientRequestBean request) throws ParseException {
		this.setAddress(request.getAddress());
		this.setDob(new SimpleDateFormat(Constants.MYSQL_FORMAT_REVERSE).format(new SimpleDateFormat(Constants.MYSQL_FORMAT).parse(request.getDob())));
		this.setContactNumber(request.getContactNumber());
		this.setGender(request.getGender());
		this.setName(request.getName());
		this.setEmergencyContact(request.getEmergencyContact());
		this.setGoiCovidId(request.getGoiCovidId());
		this.setPreExistingMedicalCondition(request.getPreExistingMedicalCondition());
	}

	public void updatePatient(PatientProfileRequestBean request) throws ParseException {
		this.setAddress(request.getAddress());
		this.setDob(new SimpleDateFormat(Constants.MYSQL_FORMAT_REVERSE).format(new SimpleDateFormat(Constants.MYSQL_FORMAT).parse(request.getDob())));
		this.setContactNumber(request.getContactNumber());
		this.setGender(request.getGender());
		this.setName(request.getName());
		this.setEmergencyContact(request.getEmergencyContact());
		this.setGoiCovidId(request.getGoiCovidId());
		this.setPreExistingMedicalCondition(request.getPreExistingMedicalCondition());
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getDob() {
		return dob;
	}

	public void setDob(String dob) throws ParseException {
		this.dob = (new SimpleDateFormat(Constants.MYSQL_FORMAT).format(new SimpleDateFormat(Constants.MYSQL_FORMAT_REVERSE).parse(dob)));
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

	public String getGoiCovidId() {
		return goiCovidId;
	}

	public void setGoiCovidId(String goiCovidId) {
		this.goiCovidId = goiCovidId;
	}

	public Object getPreExistingMedicalCondition() {
		return preExistingMedicalCondition;
	}

	public void setPreExistingMedicalCondition(Object preExistingMedicalCondition) {
		this.preExistingMedicalCondition = preExistingMedicalCondition;
	}
}