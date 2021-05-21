package com.example.onlinesportshopee.services;

import java.util.List;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.model.Customer;

public interface ICustomerService {

		public Customer addCustomer(CustomerEntity customer) throws CustomerNotFoundException;
		public Customer removeCustomer(long custId) throws CustomerNotFoundException;
		public Customer updateCustomer(long custId,CustomerEntity customer) throws CustomerNotFoundException;
		public Customer getCustomer(long custId) throws CustomerNotFoundException;
		public List<Customer> getAllCustomers(); 
}
