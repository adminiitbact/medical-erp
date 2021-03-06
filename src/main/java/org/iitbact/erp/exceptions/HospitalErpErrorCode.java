package org.iitbact.erp.exceptions;

public class HospitalErpErrorCode {
    
    public static final long DATABASE_ERROR 		= 1;
    public static final long AUTHENTICATION_ERROR 	= 2;
    public static final long INVALID_INPUT 		= 3;
    public static final long SYSTEM_ERROR_PROPERTY_FILE_NOT_FOUND = 5;
    public static final long SYSTEM_ERROR 					= 6;
    public static final long DATABASE_ERROR_NULL_CONNECTION 	= 7;
    public static final long HTTP_REQUEST_ERROR = 8;
    public static final long HTTP_RESPONSE_ERROR = 9;
    public static final long INVALID_ACCESS_CODE = 10; //illegal access
	public static final long TOKEN_INVALID = 11;
	public static final long NO_ENOUGH_BEDS = 12;
	public static final long REMOVE_WARD_FAILED = 13;
	public static final long WARD_NOT_ACTIVE = 14;
	public static final long DATE_FORMAT_ERROR = 15;
    
}


