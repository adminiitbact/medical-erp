package org.iitbact.erp.requests;

import org.iitbact.erp.constants.SEVERITY;
import org.iitbact.erp.constants.TEST_STATUS;
import org.iitbact.erp.constants.WARD_GENDER;

public class WardRequestBean extends BaseRequest {

	private int availableBeds;

	private String name;

	private int totalBeds;

	private TEST_STATUS covidStatus;

	private SEVERITY severity;

	private int icuBeds;

	private int ventilators;

	private WARD_GENDER gender;

	private boolean bedsDestance6Feet;

	private boolean covidWard;

	private boolean independentRoomsWithBedAndToilet;

	public int getAvailableBeds() {
		return availableBeds;
	}

	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalBeds() {
		return totalBeds;
	}

	public void setTotalBeds(int totalBeds) {
		this.totalBeds = totalBeds;
	}

	public TEST_STATUS getCovidStatus() {
		return covidStatus;
	}

	public void setCovidStatus(TEST_STATUS covidStatus) {
		this.covidStatus = covidStatus;
	}

	public SEVERITY getSeverity() {
		return severity;
	}

	public void setSeverity(SEVERITY severity) {
		this.severity = severity;
	}

	public int getIcuBeds() {
		return icuBeds;
	}

	public void setIcuBeds(int icuBeds) {
		this.icuBeds = icuBeds;
	}

	public int getVentilators() {
		return ventilators;
	}

	public void setVentilators(int ventilators) {
		this.ventilators = ventilators;
	}

	public WARD_GENDER getGender() {
		return gender;
	}

	public void setGender(WARD_GENDER gender) {
		this.gender = gender;
	}

	public boolean isBedsDestance6Feet() {
		return bedsDestance6Feet;
	}

	public void setBedsDestance6Feet(boolean bedsDestance6Feet) {
		this.bedsDestance6Feet = bedsDestance6Feet;
	}

	public boolean isCovidWard() {
		return covidWard;
	}

	public void setCovidWard(boolean covidWard) {
		this.covidWard = covidWard;
	}

	public boolean isIndependentRoomsWithBedAndToilet() {
		return independentRoomsWithBedAndToilet;
	}

	public void setIndependentRoomsWithBedAndToilet(boolean independentRoomsWithBedAndToilet) {
		this.independentRoomsWithBedAndToilet = independentRoomsWithBedAndToilet;
	}

	
}
