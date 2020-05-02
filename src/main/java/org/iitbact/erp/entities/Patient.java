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

import org.hibernate.annotations.TypeDef;
import org.iitbact.erp.requests.PatientProfileRequestBean;
import org.iitbact.erp.requests.PostPatientRequestBean;

import com.vladmihalcea.hibernate.type.json.JsonStringType;

@Entity
@Table(name = "patients")
@NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	@Lob
	private String address;
	private String locality;
	private String district;
	private String state;
	private String occupation;
	@Column(name = "contact_number")
	private String contactNumber;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "district_case_id")
	private String districtCaseId;

	@Column(name = "hospital_patient_id")
	private String hostpitalPatientId;

	@Column(name = "goi_covid_id")
	private String goiCovidId;

	@Column(name = "covid_uid")
	private String covidUID;

	public Patient() {
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(final String occupation) {
		this.occupation = occupation;
	}

	public String getState() {
		return state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(final String district) {
		this.district = district;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String formatDate(final String date, final String currentFormat, final String newFormat)
			throws ParseException {
		return new SimpleDateFormat(currentFormat).format(new SimpleDateFormat(newFormat).parse(date));
	}

	public Patient(final PostPatientRequestBean request) throws ParseException {
		this.setFirstName(request.getFirstName());
		this.setLastName(request.getLastName());
		this.setAge(request.getAge());
		this.setGender(request.getGender());
		this.setAddress(request.getAddress());
		this.setLocality(request.getLocality());
		this.setDistrict(request.getDistrict());
		this.setState(request.getState());
		this.setOccupation(request.getOccupation());
		this.setContactNumber(request.getContactNumber());
		this.setDistrictCaseId(request.getDistrictCaseId());
		this.setHostpitalPatientId(request.getHostpitalPatientId());
		this.setGoiCovidId(request.getGoiCovidId());
		this.setCovidUID(request.getCovidUID());
	}

	public void updatePatient(final PatientProfileRequestBean request) throws ParseException {
		this.setFirstName(request.getFirstName());
		this.setLastName(request.getLastName());
		this.setAge(request.getAge());
		this.setGender(request.getGender());
		this.setAddress(request.getAddress());
		this.setLocality(request.getLocality());
		this.setDistrict(request.getDistrict());
		this.setState(request.getState());
		this.setOccupation(request.getOccupation());
		this.setContactNumber(request.getContactNumber());
		this.setDistrictCaseId(request.getDistrictCaseId());
		this.setHostpitalPatientId(request.getHostpitalPatientId());
		this.setGoiCovidId(request.getGoiCovidId());
		this.setCovidUID(request.getCovidUID());
	}

	public String getCovidUID() {
		return this.covidUID;
	}

	public void setCovidUID(final String covidUID) {
		this.covidUID = covidUID;
	}

	public String getAddress() {
		return this.address;
	}

	public String getHostpitalPatientId() {
		return this.hostpitalPatientId;
	}

	public void setHostpitalPatientId(final String hostpitalPatientId) {
		this.hostpitalPatientId = hostpitalPatientId;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getDistrictCaseId() {
		return this.districtCaseId;
	}

	public void setDistrictCaseId(final String districtCaseId) {
		this.districtCaseId = districtCaseId;
	}

	public String getContactNumber() {
		return this.contactNumber;
	}

	public void setContactNumber(final String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(final String gender) {
		this.gender = gender;
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(final int patientId) {
		this.patientId = patientId;
	}

	public String getGoiCovidId() {
		return goiCovidId;
	}

	public void setGoiCovidId(final String goiCovidId) {
		this.goiCovidId = goiCovidId;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(final String locality) {
		this.locality = locality;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}
}