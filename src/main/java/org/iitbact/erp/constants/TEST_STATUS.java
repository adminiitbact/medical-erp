package org.iitbact.erp.constants;

public enum TEST_STATUS {
	NEGATIVE("Negative"),POSITIVE("Positive"),PENDING_RESULT("Result Pending"),PENDING_TEST("Test Pending");
	
	private String status;
	
	
	private TEST_STATUS(String status) {
		this.status=status;
	}

	
}
