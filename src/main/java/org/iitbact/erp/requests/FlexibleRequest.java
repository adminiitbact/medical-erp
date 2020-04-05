package org.iitbact.erp.requests;

import com.fasterxml.jackson.databind.JsonNode;

public  class FlexibleRequest extends BaseRequest {
	
	private JsonNode data;

	public JsonNode getData() {
		return data;
	}

	public void setData(JsonNode data) {
		this.data = data;
	}
}
