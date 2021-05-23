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

@RestController
@RequestMapping("/onlinesportshopee")
public class UserController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/login/add-user")
	public  ResponseEntity<Object> addUser(@RequestBody User User)throws UserException{
		LOGGER.info("add-user URL is opened");
		LOGGER.info("addUserEntity() is initiated");
		ResponseEntity<Object> orderResponse = null;
		User user = iUserService.addUser(User);
		orderResponse = new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		LOGGER.info("addUser() has executed");
		return orderResponse;
	}
	
	@GetMapping("/login/signin/{userId}/{password}")
	public ResponseEntity<Object> signIn(@PathVariable("userId") long userId,@PathVariable("password") String Password) throws UserException
	{
		LOGGER.info("signIn URL is opened");
		LOGGER.info("signIn() is initiated");
		User user1 = new User(userId,Password);
		User user = iUserService.signIn(user1);
		ResponseEntity<Object> response = new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		LOGGER.info("signIn() has Executed");
		return response;
	}
	
	
	@GetMapping("/login/signout")
	public ResponseEntity<Object> signOut() throws UserException
	{
		LOGGER.info("sign-out URL is opened");
		LOGGER.info("signout() is initiated");
		String signout = iUserService.signOut(null);
		ResponseEntity<Object> response = new ResponseEntity<>(signout,HttpStatus.ACCEPTED);
		LOGGER.info("signout() has Executed");
		return response;
	}
	
	@PutMapping("/login/changepassword/{userId}")
	public ResponseEntity<Object> changePassword(@PathVariable Long userId, @RequestBody User User) throws UserException
	{
		LOGGER.info("changepassword URL is opened");
		LOGGER.info("changepassword() is initiated");
		User user = iUserService.changePassword(userId, User);
		ResponseEntity<Object> response = new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		LOGGER.info("changepassword() has Executed");
		return response;
	}	
	
}
