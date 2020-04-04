package org.iitbact.erp.exceptions;

public class HospitalErpException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final long errorCode;
	private final String errorMessage;
	private final HospitalErpError error;
	private String detailedMessage;

	public HospitalErpException(final long errorCode, final String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMsg;
		this.error = new HospitalErpError(errorCode, errorMsg);
	}

	public HospitalErpError getError() {
		return error;
	}

	public HospitalErpException(final HospitalErpError error) {
		this(error.getErrorCode(), error.getErrorMsg());
	}

	public HospitalErpException(final long errorCode, final String errorMsg,
			final String detailedMessage) {
		this(errorCode, errorMsg);
		this.detailedMessage = detailedMessage;
	}

	public HospitalErpException(final long errorCode, final String errorMsg,
			final Throwable t) {
		super(t);
		this.errorCode = errorCode;
		this.errorMessage = errorMsg;
		this.error = new HospitalErpError(errorCode, errorMsg);
	}

	public HospitalErpException(final HospitalErpError error, final Throwable t) {
		this(error.getErrorCode(), error.getErrorMsg(), t);
	}

	public HospitalErpException(final long errorCode, final String errorMsg,
			final String detailedMessage, final Throwable t) {
		this(errorCode, errorMsg, t);
		this.detailedMessage = detailedMessage;
	}

	/**
	 * @return the errorCode
	 */
	public long getErrorCode() {
		return this.errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return this.errorMessage;
	}

	/**
	 * @return the detailedMessage
	 */
	public String getDetailedMessage() {
		return this.detailedMessage;
	}

}
