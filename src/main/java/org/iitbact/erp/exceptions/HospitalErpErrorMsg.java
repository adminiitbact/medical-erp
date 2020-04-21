package org.iitbact.erp.exceptions;

public class HospitalErpErrorMsg {
    
    public static final String SYSTEM_ERROR = "Oops! There seems to be something wrong. Please try after some time.";
    public static final String SYSTEM_ERROR_PROPERTY_FILE_NOT_FOUND = "Oops! There seems to be something wrong. Please try after some time.";
    public static final String DATABASE_ERROR = "Oops! There seems to be something wrong. Please try after some time.";
    public static final String INVALID_INPUT = "Oops! There seems to be something wrong. Please try after some time.";
    public static final String HTTP_REQUEST_ERROR = "Oops! There seems to be something wrong. Please try after some time.";
    public static final String HTTP_RESPONSE_ERROR =  "Oops! There seems to be something wrong. Please try after some time.";
    public static final String INVALID_ACCESS_CODE = "Unauthorized access!";
	public static final String COOKIE_NULL = "Token cannot be null";
	public static final String INVALID_OTP = "Invalid Otp!";
	public static final String DATE_FORMAT_ERROR = "Date is not in correct format!";
	public static final String NO_ENOUGH_BEDS = "No bed is available in this ward!";
	public static final String REMOVE_WARD_FAILED = "Please transfer the existing patients to another ward or facility before removing the ward";
	public static final String NEGATIVE_VALUES = "Negative values not allowed!";
	public static final String MORE_PATIENT_EXIST = "Total beds cannot be less than beds total occupied beds within ward!";
	public static final String WARD_NOT_ACTIVE = "Cannot change ward details as ward is not active anymore!";
	
}
