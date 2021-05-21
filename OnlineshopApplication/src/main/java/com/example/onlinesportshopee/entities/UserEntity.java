package com.example.onlinesportshopee.entities;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "password")
	private String password;
	
	public UserEntity() {
		super();
	}
	
	public UserEntity(Long id, String password) {
		super();
		this.id=id;
		this.password = password;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserEntity [userid=" + id + ", password=" + password + "]";
	}
	
	

}
