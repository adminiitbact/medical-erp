package org.iitbact.erp.requests;

import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;

public class PostPatientRequestBean extends BaseRequest {
	private String address;
	private int age;
	private String contactNumber;
	private String gender;
	private String name;
	private String emergencyContact;
	
	private Object preExistingMedicalCondition;
	
	private String goiCovidId;
	private String patientHospitalId;
	private int facilityId;
	private int wardId;
	private TEST_STATUS testStatus;
	private SEVERITY severity;

	
	public String getPatientHospitalId() {
		return patientHospitalId;
	}

	public void setPatientHospitalId(String patientHospitalId) {
		this.patientHospitalId = patientHospitalId;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public TEST_STATUS getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(TEST_STATUS testStatus) {
		this.testStatus = testStatus;
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
