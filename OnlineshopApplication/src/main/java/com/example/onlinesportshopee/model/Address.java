package com.example.onlinesportshopee.model;

import com.example.onlinesportshopee.entities.CustomerEntity;

public class Address 
{
	private String doorNo;
	private String street;
	private String area;
	private String city;
	private String state;
	private Integer pincode;
<<<<<<< HEAD
	//private Customer customer;
=======
	
>>>>>>> branch 'master' of https://github.com/Sprint-1CaseStudy/OnlineSportsShopeee.git
	
	public Address()
	{
		super();
	}
		
	public Address(String doorNo, String street, String area, String city, String state, Integer pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
<<<<<<< HEAD
		//this.customer = customer;
=======
		
>>>>>>> branch 'master' of https://github.com/Sprint-1CaseStudy/OnlineSportsShopeee.git
	}

	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	
<<<<<<< HEAD
	/*
	 * public CustomerEntity getCustomerEntity() { return customerEntity; } public
	 * void setCustomerEntity(CustomerEntity customerEntity) { this.customerEntity =
	 * customerEntity; }
	 */
=======
	
>>>>>>> branch 'master' of https://github.com/Sprint-1CaseStudy/OnlineSportsShopeee.git
	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
<<<<<<< HEAD
				+ state + ", pincode=" + pincode +  "]";
=======
				+ state + ", pincode=" + pincode + "]";
>>>>>>> branch 'master' of https://github.com/Sprint-1CaseStudy/OnlineSportsShopeee.git
	}
	
	
	
}
