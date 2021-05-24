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
	
	public Customer addCustomer(Customer customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer() service is initiated");
		CustomerEntity customerentity = CustomerUtils.convertToCustomerEntity(customer);
	
			customerentity = icustomerRepository.save(customerentity);
		LOGGER.info("addCustomer() service has executed");
		return CustomerUtils.convertToCustomer(customerentity);
	}

	@Override
	public Customer removeCustomer(Long custId) throws CustomerNotFoundException{
		LOGGER.info("removeCustomer() service is initiated");
		CustomerEntity existcustomer = icustomerRepository.findById(custId).orElse(null);
			icustomerRepository.delete(existcustomer);
		LOGGER.info("removeCustomer() service has executed");
		return CustomerUtils.convertToCustomer(existcustomer);
	}

	@Override
	public Customer updateCustomer(Long custId, Customer customer) throws CustomerNotFoundException{

		LOGGER.info("updateCustomer() service is initiated");
		CustomerEntity customerentity = CustomerUtils.convertToCustomerEntity(customer);
		CustomerEntity updatecustomer = icustomerRepository.findById(custId).orElse(null);
	
			customerentity = icustomerRepository.save(customerentity);
		
		LOGGER.info("updateCustomer() service has executed");
		return CustomerUtils.convertToCustomer(customerentity);
	}

	@Override
	public Customer getCustomer(Long custId) throws CustomerNotFoundException{
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
