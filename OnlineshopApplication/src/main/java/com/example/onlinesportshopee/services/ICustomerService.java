package com.example.onlinesportshopee.services;

import java.util.List;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.model.Customer;

public interface ICustomerService {

		public Customer addCustomer(Customer customer) throws CustomerNotFoundException;
		public Customer removeCustomer(Long custId) throws CustomerNotFoundException;
		public Customer updateCustomer(Long custId,Customer customer) throws CustomerNotFoundException;
		public Customer getCustomer(Long custId) throws CustomerNotFoundException;
		public List<Customer> getAllCustomers(); 
}
