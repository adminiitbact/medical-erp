package org.iitbact.erp.controllers;

import org.iitbact.erp.requests.BaseRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SvcHealthController {
	@GetMapping(path = "/alive")
	public String isAlive() {
		return "OK";
	}
	
	@GetMapping(path = "/getenv")
	public String GetEnv() {
		return "Running in env: " + System.getProperty("ENV");
	}
}
