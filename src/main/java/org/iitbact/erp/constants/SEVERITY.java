package org.iitbact.erp.constants;

import java.util.HashMap;
import java.util.Map;

public enum SEVERITY {
	
    MILD("Mild or Very Mild"),MODERATE("Moderate"),SEVERE("Severe"),NO_SYMPTOMS("No Symptoms");
	
	private String severity;
	
	 // Reverse-lookup map for getting a severity
    private static final Map<String, SEVERITY> lookup = new HashMap<String, SEVERITY>();

    static {
        for (SEVERITY s : SEVERITY.values()) {
            lookup.put(s.getSeverity(), s);
        }
    }
	
	private SEVERITY(String severity) {
		this.severity=severity;
	}

	
    public static SEVERITY get(String severity) {
        return lookup.get(severity);
    }


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}
}
