package com.example.OnlineSportsShopee;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.model.Address;
import com.example.onlinesportshopee.model.Customer;

import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	ICustomerRepository iCustomerRepository;
	
	@Autowired 
	TestEntityManager testEntityManager;
	
	@Test
	public void testaddCustomer() throws Exception
	{
		Customer customer = new Customer();
		Address address = new Address();
		address.setDoorNo(10);
		
	}

}
