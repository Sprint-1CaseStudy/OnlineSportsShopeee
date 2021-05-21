package com.example.onlinesportshopee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.exception.AddressNotFoundException;
import com.example.onlinesportshopee.model.Address;
import com.example.onlinesportshopee.services.AddressServiceImpl;
import com.example.onlinesportshopee.services.IAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressServiceImpl addressServiceImpl;

	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress URL is opened");
		LOGGER.info("addAddress() is initiated");
		LOGGER.info("addAddress() has executed");
		return addressServiceImpl.addAddress(address);
	}

	@DeleteMapping("/removeAddress/Address/{custId}")
	public Address removeAddress(@PathVariable long custId) throws AddressNotFoundException {
		LOGGER.info("removeAddress URL is opened");
		LOGGER.info("removeAddress() is initiated");
		LOGGER.info("removeAddress() has executed");
		return addressServiceImpl.removeAddress(custId);
	}

	@PutMapping("/updateAddress/{custId}")
	public Address updateAddress(@PathVariable long custId,@RequestBody AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("updateAddress URL is opened");
		LOGGER.info("updateAddress() is initiated");
		LOGGER.info("updateAddress() has executed");
		return addressServiceImpl.updateAddress(custId, address);
	}

	@GetMapping("/getAddressDetails/{custId}")
	public Address getAddress(@PathVariable long custId) throws AddressNotFoundException {
		LOGGER.info("getAddressDetails URL is opened");
		LOGGER.info("getAddress() is initiated");
		LOGGER.info("getAddress() has executed");
		return addressServiceImpl.getAddress(custId);
	}
	
	//

}
