package com.example.onlinesportshopee.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.model.Address;

public class Customer 
{
	private String userID;
	private String name;
	private String email;
	private String contactNo;
	private LocalDate doB;
	private List<AddressEntity> addressEntity;
	
	public Customer()
	{
		super();
	}
	
	public Customer(String userID, String name, String email, String contactNo, LocalDate doB, List<AddressEntity> addressentity) 
	{
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.doB = doB;
		this.addressEntity = addressEntity;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public LocalDate getDoB() {
		return doB;
	}
	public void setDoB(LocalDate doB) {
		this.doB = doB;
	}
	public List<AddressEntity> getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(List<AddressEntity> addressEntity) {
		this.addressEntity = addressEntity;
	}

	@Override
	public String toString() {
		return "Customer [userID=" + userID + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", doB=" + doB + ", addressEntity=" + addressEntity + "]";
	}	
}
