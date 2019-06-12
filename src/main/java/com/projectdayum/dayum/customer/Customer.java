package com.projectdayum.dayum.customer;

import org.springframework.data.annotation.Id;

public class Customer {

	public Address address;
	
	public String firstName;
	
	@Id
	public String id;
	
	public String lastName;

	public Address getAddress() {
		return this.address;
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
