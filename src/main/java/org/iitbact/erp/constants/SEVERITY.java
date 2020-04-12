package org.iitbact.erp.constants;

public enum SEVERITY {
	
    MILD("Mild or Very Mild"),MODERATE("Moderate"),SEVERE("Severe"),NO_SYMPTOMS("No Symptoms");
	
	private String severity;
	
	private SEVERITY(String severity) {
		this.severity=severity;
	}

	
}
