package org.iitbact.erp.beans;

import org.iitbact.erp.exceptions.HospitalErpError;

public class ResponseBuilder {
	private HospitalErpError error;
	private BaseBean data;
	
	public ResponseBuilder() {}
	
	public ResponseBuilder(BaseBean data, HospitalErpError error) {
		this.data = data;
		this.error = error;
	}
	
	public ResponseBean build() {
		return new ResponseBean(this);
	}

	public HospitalErpError getError() {
		return error;
	}

	public BaseBean getData() {
		return data;
	}

	public void setError(HospitalErpError error) {
		this.error = error;
	}

	public void setData(BaseBean data) {
		this.data = data;
	}
}
