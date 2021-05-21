package com.example.onlinesportshopee.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.model.User;
import com.example.onlinesportshopee.services.IUserService;
import com.example.onlinesportshopee.services.UserServiceImpl;

@RestController
@RequestMapping("/login")
public class UserController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/signin/{userId}/{password}")
	public ResponseEntity<Object> signin(@PathVariable Long userId,@PathVariable String Password) throws UserException
	{
		LOGGER.info("sign-in URL is opened");
		LOGGER.info("signin() is initiated");
		UserEntity userdata = new UserEntity(userId,null,Password);
		UserEntity user = iUserService.signIn(userdata);
		ResponseEntity<Object> response = new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		LOGGER.info("signin() has Executed");
		return response;
	}
	
	
	@GetMapping("/signout")
	public ResponseEntity<Object> signOut() throws UserException
	{
		LOGGER.info("sign-out URL is opened");
		LOGGER.info("signout() is initiated");
		String signout = iUserService.signOut(null);
		ResponseEntity<Object> response = new ResponseEntity<>(signout,HttpStatus.ACCEPTED);
		LOGGER.info("signout() has Executed");
		return response;
	}
	
	@PutMapping("/changepassword/{userId}")
	public ResponseEntity<Object> signin(@PathVariable long userId, @RequestBody UserEntity User) throws UserException
	{
		LOGGER.info("changepassword URL is opened");
		LOGGER.info("changepassword() is initiated");
		User user = iUserService.changePassword(userId, User);
		ResponseEntity<Object> response = new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		LOGGER.info("changepassword() has Executed");
		return response;
	}	
	
}
