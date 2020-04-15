package org.iitbact.erp.constants;

public enum SEVERITY {
	
    MILD("Mild or Very Mild"),MODERATE("Moderate"),SEVERE("Severe");
	
	private String severity;
	
	private SEVERITY(String severity) {
		this.severity=severity;
	}

	
}
