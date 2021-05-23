package com.example.onlinesportshopee.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.model.Customer;
import com.example.onlinesportshopee.services.CustomerServiceImpl;
import com.example.onlinesportshopee.services.ICustomerService;

//
@RestController
@RequestMapping("/onlinesportshopee")
public class CustomerController 
{
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/customers/addCustomer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer URL is opened");
		LOGGER.info("addCustomer() is initiated");
		Customer customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO = iCustomerService.addCustomer(customer);
		customerResponse = new ResponseEntity(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addCustomer() is executed");
		return customerResponse;
	}
	
	@DeleteMapping("/customers/removeCustomer/Customer/{custId}")
	public ResponseEntity<Object> removeCustomer(@PathVariable long custId) throws CustomerNotFoundException {
		LOGGER.info("removeCustomer URL is opened");
		LOGGER.info("removeCustomer() is initiated");
		Customer customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO = iCustomerService.removeCustomer(custId);
		customerResponse = new ResponseEntity(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("removeCustomer() is executed");
		return customerResponse;
	}

	@PutMapping("/customers/updateCustomer/{custId}")
	public ResponseEntity<Object> updateCustomer(@PathVariable long custId,@RequestBody Customer customer) throws CustomerNotFoundException {
		LOGGER.info("updateCustomer URL is opened");
		LOGGER.info("updateCustomer() is initiated");
		Customer customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO = iCustomerService.updateCustomer(custId, customer);
		customerResponse = new ResponseEntity(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("updateCustomer() is executed");
		return customerResponse;
	}

	@GetMapping("/customers/getCustomerDetails/{custId}")
	public ResponseEntity<Object> getCustomer(@PathVariable long custId) throws CustomerNotFoundException {
		LOGGER.info("getCustomerDetails URL is opened");
		LOGGER.info("getCustomer() is initiated");
		Customer customerDTO = null;
		ResponseEntity<Object> customerResponse = null;
		customerDTO = iCustomerService.getCustomer(custId);
		customerResponse = new ResponseEntity(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("getCustomer() is executed");
		return customerResponse;
	}


	@GetMapping("/customers/Customers")
	public ResponseEntity<Object> getAllCustomers() {
		LOGGER.info("Customers URL is opened");
		LOGGER.info("getAllCustomers() is initiated");
		LOGGER.info("getAllCustomers() has executed");
		ResponseEntity<Object> customerResponse = null;
		List<Customer> customerDTO = iCustomerService.getAllCustomer();
		customerResponse=new ResponseEntity(customerDTO)
		return ResponseEntity(List<>);
	}
	
}
