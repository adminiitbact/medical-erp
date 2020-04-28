package org.iitbact.erp.requests;

public class PatientProfileRequestBean extends BaseRequest {
	private String address;

	private String dob;

	private String contactNumber;

	private String gender;

	private String name;

	private String emergencyContact;

	private String goiCovidId;

	private Object preExistingMedicalCondition;
	
	private String locality;
	private String pincode;

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

	public String getGoiCovidId() {
		return goiCovidId;
	}

	public void setGoiCovidId(String goiCovidId) {
		this.goiCovidId = goiCovidId;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
