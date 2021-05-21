package com.example.onlinesportshopee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.IAddressRepository;
import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.exception.AddressNotFoundException;
import com.example.onlinesportshopee.model.Address;
import com.example.onlinesportshopee.util.AddressUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AddressServiceImpl {
//
	static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Autowired
	private IAddressRepository iaddressRepository;
	
	public Address addAddress(AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress() service is initiated");
		AddressEntity addressentity;
		if(address == null)
			addressentity = null;
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("addAddress() service has executed");
		return AddressUtils.convertToAddress(addressentity);
	}
	
	public Address removeAddress(long custId) throws AddressNotFoundException{
		LOGGER.info("removeAddress() service is initiated");
		AddressEntity existaddress = iaddressRepository.findById(custId).orElse(null);
		if(existaddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		else {
			iaddressRepository.delete(existaddress);
		}
		LOGGER.info("removeAddress() service has executed");
		return AddressUtils.convertToAddress(existaddress);
	}
	
	public Address updateAddress(long custId, AddressEntity address) throws AddressNotFoundException{
		// TODO Auto-generated method stub
		LOGGER.info("updateAddress() service is initiated");
		AddressEntity addressentity = null;
		AddressEntity updateaddress = iaddressRepository.findById(custId).orElse(null);
		if(updateaddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("updateAddress() service has executed");
		return AddressUtils.convertToAddress(addressentity);
	}
	
	public Address getAddress(long custId) throws AddressNotFoundException{
		LOGGER.info("getAddress() service is initiated");
		AddressEntity getAddress = iaddressRepository.findById(custId).orElse(null);
		if(getAddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		LOGGER.info("getAddress() service has executed");
		return AddressUtils.convertToAddress(getAddress);
	}
	
}
