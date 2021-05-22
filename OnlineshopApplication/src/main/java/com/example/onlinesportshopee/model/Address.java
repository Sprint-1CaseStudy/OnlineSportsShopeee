package com.example.onlinesportshopee.model;

import com.example.onlinesportshopee.entities.CustomerEntity;

public class Address 
{
	private Long id;
	private String street;
	private String area;
	private String city;
	private String state;
	private Integer pincode;
	private CustomerEntity customerEntity;
	
	public Address()
	{
		super();
	}
		
	public Address(Long id, String street, String area, String city, String state, Integer pincode,
			CustomerEntity customerEntity) {
		super();
		this.id = id;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.customerEntity = customerEntity;
	}

	public Long getID() {
		return id;
	}
	public void setID(Long id) {
		this.id = id;
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
	
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", customerEntity=" + customerEntity + "]";
	}
	
	
	
}
