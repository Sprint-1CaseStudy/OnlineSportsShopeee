package com.example.onlinesportshopee.entities;

import javax.persistence.*;

import com.example.onlinesportshopee.entities.CustomerEntity;

@Entity
@Table(name = "address")
public class AddressEntity 
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "street")
	private String street;
	@Column(name = "area")
	private String area;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private Integer pincode;
	@ManyToOne
    @JoinColumn
    private CustomerEntity customerEntity;
	
	@Override
	public String toString() {
		return "AddressEntity [id=" + id + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
				+ state + ", pincode=" + pincode + ", customerEntity=" + customerEntity + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public AddressEntity(Long id, String street, String area, String city, String state, Integer pincode,
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
	public AddressEntity() {
		
	}

	
	
	
}
