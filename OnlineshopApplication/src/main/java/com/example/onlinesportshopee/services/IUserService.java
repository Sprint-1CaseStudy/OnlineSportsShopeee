package com.example.onlinesportshopee.services;


import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.model.User;

public interface IUserService {

	public User addUser(User user) throws UserException;
	public User signIn(User user) throws UserException;
	public String signOut(User user);
	public User changePassword(Long id,User user) throws UserException;
	

}
