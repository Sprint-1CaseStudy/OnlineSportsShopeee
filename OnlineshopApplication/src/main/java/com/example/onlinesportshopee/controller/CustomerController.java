package com.example.onlinesportshopee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.model.Customer;
import com.example.onlinesportshopee.services.CustomerServiceImpl;
import com.example.onlinesportshopee.services.ICustomerService;

//
@RestController
@RequestMapping("/customers")
public class CustomerController 
{
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer URL is opened");
		LOGGER.info("addCustomer() is initiated");
		LOGGER.info("addCustomer() is executed");
		return iCustomerService.addCustomer(customer);
	}
	
	@DeleteMapping("/removeCustomer/Customer/{custId}")
	public Customer removeCustomer(@PathVariable long custId) throws CustomerNotFoundException {
		LOGGER.info("removeCustomer URL is opened");
		LOGGER.info("removeCustomer() is initiated");
		LOGGER.info("removeCustomer() is executed");
		return iCustomerService.removeCustomer(custId);
	}

	@PutMapping("/updateCustomer/{custId}")
	public Customer updateCustomer(@PathVariable long custId,@RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("updateCustomer URL is opened");
		LOGGER.info("updateCustomer() is initiated");
		LOGGER.info("updateCustomer() is executed");
		return iCustomerService.updateCustomer(custId, customer);
	}

	@GetMapping("/getCustomerDetails/{custId}")
	public Customer getCustomer(@PathVariable long custId) throws CustomerNotFoundException {
		LOGGER.info("getCustomerDetails URL is opened");
		LOGGER.info("getCustomer() is initiated");
		LOGGER.info("getCustomer() is executed");
		return iCustomerService.getCustomer(custId);
	}

	@GetMapping("/Customers/{name}")
	public List<Customer> getAllCustomers(@PathVariable String name) {
		LOGGER.info("Customers URL is opened");
		LOGGER.info("getAllCustomers() is initiated");
		LOGGER.info("getAllCustomers() has executed");
		return iCustomerService.getAllCustomers();
	}
	
}
