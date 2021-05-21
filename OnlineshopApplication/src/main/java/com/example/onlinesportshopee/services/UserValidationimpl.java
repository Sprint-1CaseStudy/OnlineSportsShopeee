package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;

public class UserValidationimpl {
	
	public static UserEntity validateUser(UserEntity user) throws UserException {
			if(user.getUsername() != null)
			{
				if(user.getPassword() != null)
				{
					return user;
				}
				else throw new UserException("Password cannot be empty");
			}
			else throw new UserException("Username cannot be empty");
	}	
}
