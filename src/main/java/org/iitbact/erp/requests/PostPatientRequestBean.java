package org.iitbact.erp.requests;

import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;

public class PostPatientRequestBean extends BaseRequest {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private String locality;
	private String district;
	private String state;
	private String occupation;
	private String contactNumber;
	private String districtCaseId;
	private String hostpitalPatientId;
	private String goiCovidId;
	private String covidUID;

	private String dob;
	private String name;
	private String emergencyContact;
	private String pincode;
	private int month;
	private Object preExistingMedicalCondition;

	private String patientHospitalId;
	private int facilityId;
	private int wardId;
	private TEST_STATUS testStatus;
	private SEVERITY severity;

	public String getPatientHospitalId() {
		return patientHospitalId;
	}

	public String getCovidUID() {
		return covidUID;
	}

	public void setCovidUID(String covidUID) {
		this.covidUID = covidUID;
	}

	public String getHostpitalPatientId() {
		return hostpitalPatientId;
	}

	public void setHostpitalPatientId(String hostpitalPatientId) {
		this.hostpitalPatientId = hostpitalPatientId;
	}

	public String getDistrictCaseId() {
		return districtCaseId;
	}

	public void setDistrictCaseId(String districtCaseId) {
		this.districtCaseId = districtCaseId;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getAge() {
		return age;
	}

	public int getMonth() {
		return month;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
