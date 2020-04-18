package org.iitbact.erp.requests;

import org.iitbact.erp.constants.PatientType;
import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.WARD_GENDER;

import io.swagger.annotations.ApiModelProperty;

public class WardRequestBean extends BaseRequest {
	
	@ApiModelProperty(value = "wardId = 0 in case of adding a new ward & non zero othrwise")
	private int wardId;
	
	private String name;
	private String buildingName;
	private String wardNumber;
	private String floorNo;
	private PatientType patientType;
	private SEVERITY severity;
	private WARD_GENDER gender;
	
	private int totalBeds;
	private int bedsOccupied;
	
	private int icuBeds;
	private int icuBedsOccupied;
	private int ventilators;
	private int ventilatorsOccupied;
	
	@ApiModelProperty(value = "Other fields ,please refer to field highlight in green https://docs.google.com/presentation/d/1G2P_uVOqln2j2UGLSJ0q28a5bfdTaZHywCeVX1w9mHM/edit#slide=id.g73475c0e45_0_152")
	private Object extraFields;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBuildingName() {
		return buildingName;
	}


	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}


	public String getFloorNo() {
		return floorNo;
	}


	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}


	public PatientType getPatientType() {
		return patientType;
	}


	public void setPatientType(PatientType patientType) {
		this.patientType = patientType;
	}


	public SEVERITY getSeverity() {
		return severity;
	}


	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}


	public WARD_GENDER getGender() {
		return gender;
	}


	public void setGender(WARD_GENDER gender) {
		this.gender = gender;
	}


	public int getTotalBeds() {
		return totalBeds;
	}


	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}


	public int getBedsOccupied() {
		return bedsOccupied;
	}


	public void setBedsOccupied(int bedsOccupied) {
		this.bedsOccupied = bedsOccupied;
	}


	public int getIcuBeds() {
		return icuBeds;
	}


	public void setIcuBeds(int icuBeds) {
		this.icuBeds = icuBeds;
	}


	public int getIcuBedsOccupied() {
		return icuBedsOccupied;
	}


	public void setIcuBedsOccupied(int icuBedsOccupied) {
		this.icuBedsOccupied = icuBedsOccupied;
	}


	public int getVentilators() {
		return ventilators;
	}


	public void setVentilators(int ventilators) {
		this.ventilators = ventilators;
	}


	public int getVentilatorsOccupied() {
		return ventilatorsOccupied;
	}


	public void setVentilatorsOccupied(int ventilatorsOccupied) {
		this.ventilatorsOccupied = ventilatorsOccupied;
	}


	public int getWardId() {
		return wardId;
	}
	public void setWardId(int wardId) {
		this.wardId = wardId;
	}


	public Object getExtraFields() {
		return extraFields;
	}


	public void setExtraFields(Object extraFields) {
		this.extraFields = extraFields;
	}


	public String getWardNumber() {
		return wardNumber;
	}


	public void setWardNumber(String wardNumber) {
		this.wardNumber = wardNumber;
	}
}
