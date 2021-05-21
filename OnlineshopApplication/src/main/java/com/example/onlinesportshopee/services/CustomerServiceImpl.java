package com.example.onlinesportshopee.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.model.Customer;
import com.example.onlinesportshopee.util.CustomerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl implements ICustomerService {
//
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
		
	@Autowired
	private ICustomerRepository icustomerRepository;
	
	@Override
	public Customer addCustomer(CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer() service is initiated");
		CustomerEntity customerentity;
		if(customer == null)
			customerentity = null;
		else {
			customerentity = icustomerRepository.save(customer);
		}
		LOGGER.info("addCustomer() service has executed");
		return CustomerUtils.convertToCustomer(customerentity);
	}

	@Override
	public Customer removeCustomer(long custId) throws CustomerNotFoundException{
		LOGGER.info("removeCustomer() service is initiated");
		CustomerEntity existcustomer = icustomerRepository.findById(custId).orElse(null);
		if(existcustomer == null)
		{
			throw new CustomerNotFoundException("CustomerNotFound");
		}
		else {
			icustomerRepository.delete(existcustomer);
		}
		LOGGER.info("removeCustomer() service has executed");
		return CustomerUtils.convertToCustomer(existcustomer);
	}

	@Override
	public Customer updateCustomer(long custId, CustomerEntity customer) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		LOGGER.info("updateCustomer() service is initiated");
		CustomerEntity customerentity = null;
		CustomerEntity updatecustomer = icustomerRepository.findById(custId).orElse(null);
		if(updatecustomer == null)
		{
			throw new CustomerNotFoundException("CustomerNotFound");
		}
		else {
			customerentity = icustomerRepository.save(customer);
		}
		LOGGER.info("updateCustomer() service has executed");
		return CustomerUtils.convertToCustomer(customerentity);
	}

	@Override
	public Customer getCustomer(long custId) throws CustomerNotFoundException{
		LOGGER.info("getCustomer() service is initiated");
		CustomerEntity getCustomer = icustomerRepository.findById(custId).orElse(null);
		if(getCustomer == null)
		{
			throw new CustomerNotFoundException("CustomerNotFound");
		}
		LOGGER.info("getCustomer() service has executed");
		return CustomerUtils.convertToCustomer(getCustomer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		LOGGER.info("getAllCustomer() service is initiated");
		List<CustomerEntity> custlist = icustomerRepository.findAll();
		LOGGER.info("getAllCustomer() service has executed");
		return CustomerUtils.convertToCustomerList(custlist);
	}
}
