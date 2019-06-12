package com.projectdayum.dayum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectdayum.dayum.customer.CustomerDataAccess;

@RestController
public class TestController {

	@Autowired
	private CustomerDataAccess customerDataAccess;

	@GetMapping("/test")
	String getSomething() {
		System.out.println("TEST");
		this.customerDataAccess.saveSomething();
		this.customerDataAccess.getSomething();
		return "TEST123";
	}
}
