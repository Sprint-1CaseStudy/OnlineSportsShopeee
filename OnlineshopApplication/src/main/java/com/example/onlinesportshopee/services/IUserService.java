package com.example.onlinesportshopee.services;


import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.model.User;

public interface IUserService {

	public User addUser(UserEntity user) throws UserException;
	public User signIn(UserEntity user) throws UserException;
	public String signOut(UserEntity user);
	public User changePassword(long id,UserEntity user) throws UserException;
	

}
