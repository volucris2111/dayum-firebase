package com.projectdayum.dayum.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDataAccess customerRepository;

	@GetMapping("/customer/create")
	public String createNewCustomer() {
		return this.customerRepository.saveSomething();
	}

	@GetMapping(path = "/customer/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getSomething() {
		return this.customerRepository.getSomething();
	}

	@GetMapping(path = "/customer/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> gtById(@PathVariable String id) {
		return this.customerRepository.getById(id);
	}

	@GetMapping(path = "/customer/zip/{zip}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> gtByZip(@PathVariable String zip) {
		return this.customerRepository.getByZip(zip);
	}
}
