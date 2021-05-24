package com.example.onlinesportshopee.entities;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.*;




@Entity
@Table(name = "Customer")
public class CustomerEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "contactno")
	private String contactNo;
	@Column(name = "DateOfBirth")
	private LocalDate doB;
	@OneToMany(cascade = CascadeType.ALL)
	private List<AddressEntity> addressEntity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
		return "CustomerEntity [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
				+ ", doB=" + doB + ", addressEntity=" + addressEntity + "]";
	}
	public CustomerEntity(Long id, String name, String email, String contactNo, LocalDate doB,
			List<AddressEntity> addressEntity) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.doB = doB;
		this.addressEntity = addressEntity;
	}
	public CustomerEntity() {}

	
	
	
	
}
