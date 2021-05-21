package com.example.onlinesportshopee.util;

import java.util.ArrayList;
import java.util.List;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.model.Customer;

public class CustomerUtils 
{
	private CustomerUtils()
	{
		
	}
	public static List<Customer> convertToCustomerList(List<CustomerEntity> list){
		List<Customer> customerList = new ArrayList<>();
		for(CustomerEntity cust : list) 
			customerList.add(convertToCustomer(cust));
		return customerList;
	}
	
	public static CustomerEntity convertToCustomerEntity(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(Long.parseLong(customer.getUserID()));
		customerEntity.setName(customer.getName());
		customerEntity.setEmail(customer.getEmail());
		customerEntity.setContactNo(customer.getContactNo());
		customerEntity.setDoB(customer.getDoB());
		customerEntity.setAddressEntity(customer.getAddressEntity());
		
		return customerEntity;
	}		
	
	public static Customer convertToCustomer(CustomerEntity customerEntity) {
		Customer customer = new Customer();
		customer.setUserID(customerEntity.getId().toString());
		customer.setName(customerEntity.getName());
		customer.setEmail(customerEntity.getEmail());
		customer.setContactNo(customerEntity.getContactNo());
		customer.setDoB(customerEntity.getDoB());
		customer.setAddressEntity(customerEntity.getAddressEntity());
		customerEntity.setOrderEntity(customer.getOrderEntity());
		return customer;
	}
}
