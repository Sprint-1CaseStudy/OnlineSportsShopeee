package com.example.onlinesportshopee.model;

public class User {
	
	private Long id;
	private String username;
	private String password;
	
	public User() {
		super();
	}

	public User(Long userId, String username, String password) {
		super();
		this.id = userId;
		this.username = username;
		this.password = password;
	}

	public User(long userId, String password) {
		super();
		this.id = userId;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long userId) {
		this.id = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + id + ", username=" + username + ", password=" + password + "]";
	}

}
