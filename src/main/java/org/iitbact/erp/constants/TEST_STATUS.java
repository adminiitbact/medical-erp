package org.iitbact.erp.constants;

import java.util.HashMap;
import java.util.Map;

public enum TEST_STATUS {
	NEGATIVE("Negative"),POSITIVE("Positive"),PENDING_RESULT("Result Pending"),PENDING_TEST("Test Pending");
	
	private String status;
	
	 // Reverse-lookup map for getting a severity
    private static final Map<String, TEST_STATUS> lookup = new HashMap<String, TEST_STATUS>();

    static {
        for (TEST_STATUS testStatus : TEST_STATUS.values()) {
            lookup.put(testStatus.getStatus(), testStatus);
        }
    }
	
	
	private TEST_STATUS(String status) {
		this.status=status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static TEST_STATUS get(String status) {
        return lookup.get(status);
    }

}
