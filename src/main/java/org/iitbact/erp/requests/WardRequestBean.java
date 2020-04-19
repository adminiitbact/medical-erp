package org.iitbact.erp.requests;

import org.iitbact.erp.constants.CovidStatus;
import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.WARD_GENDER;

import io.swagger.annotations.ApiModelProperty;

public class WardRequestBean extends BaseRequest {
	
	@ApiModelProperty(value = "wardId = 0 in case of adding a new ward & non zero othrwise")
	private int wardId;
	private String name;
	private String buildingName;
	private String wardNumber;
	private String floor;
	private CovidStatus covidStatus;
	private SEVERITY severity;
	private WARD_GENDER gender;
	private int totalBeds;
	private int ventilators;
	private int ventilatorsOccupied;
	private boolean covidWard;
	
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


	public CovidStatus getCovidStatus() {
		return covidStatus;
	}


	public void setCovidStatus(CovidStatus covidStatus) {
		this.covidStatus = covidStatus;
	}


	public boolean isCovidWard() {
		return covidWard;
	}

	public void setCovidWard(boolean covidWard) {
		this.covidWard = covidWard;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
}
