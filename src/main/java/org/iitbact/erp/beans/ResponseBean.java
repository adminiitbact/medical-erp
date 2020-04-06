package org.iitbact.erp.beans;

import org.iitbact.erp.exceptions.HospitalErpError;

public class ResponseBean {
	private HospitalErpError error;
	private BaseBean data;

	ResponseBean(ResponseBuilder builder) {
		if (builder.getError() != null) {
			this.setError(builder.getError());
		} else {
			this.setData(builder.getData());
		}
	}
	
	public HospitalErpError getError() {
		return error;
	}

	private void setError(HospitalErpError error) {
		this.error = error;
	}

	/**
	 * @return the data
	 */
	public BaseBean getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	private void setData(BaseBean data) {
		this.data = data;
	}
}
