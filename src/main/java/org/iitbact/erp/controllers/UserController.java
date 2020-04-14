package org.iitbact.erp.controllers;

import org.iitbact.erp.beans.ResponseBean;
import org.iitbact.erp.beans.ResponseBuilder;
import org.iitbact.erp.entities.AdminUser;
import org.iitbact.erp.exceptions.HospitalErpError;
import org.iitbact.erp.exceptions.HospitalErpException;
import org.iitbact.erp.requests.BaseRequest;
import org.iitbact.erp.response.AdminUserProfile;
import org.iitbact.erp.response.ErpUserProfile;
import org.iitbact.erp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	
	@PostMapping(path = "/hospital/user/profile")
	@ApiOperation(response = ErpUserProfile.class,value = "Api to fetch user profile for a particular hospital")
	public ResponseBean userProfile(@RequestBody BaseRequest request) {
		HospitalErpError error = null;
		ErpUserProfile data=null;
		try {
			data=userServices.profile(request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}
	
	@PostMapping(path = "/admin/user/profile")
	@ApiOperation(response = AdminUser.class,value = "Api to fetch user profile for a particular hospital")
	public ResponseBean adminUserProfile(@RequestBody BaseRequest request) {
		HospitalErpError error = null;
		AdminUserProfile data=null;
		try {
			data=userServices.adminProfile(request);
		} catch (HospitalErpException e) {
			error = e.getError();
		}
		ResponseBuilder responseBuilder = new ResponseBuilder(data,error);
		return responseBuilder.build();
	}

}
