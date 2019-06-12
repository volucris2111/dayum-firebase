package com.projectdayum.dayum.customer;

public class Address {
	private String city;
	private String street;
	private ZipCity zipCity;
	
	public String getCity() {
		return this.city;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public ZipCity getZipCity() {
		return this.zipCity;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setZipCity(ZipCity zipCity) {
		this.zipCity = zipCity;
	}
}
