package com.example.OnlineSportsShopee.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerRepositoryTest {

	@Autowired
	ICustomerRepository iCustomerRepository;
	
	@Autowired 
	TestEntityManager testEntityManager;
	
	@Test
	public void testgetCustomer() throws Exception
	{
		CustomerEntity customer = new CustomerEntity();
		AddressEntity address = new AddressEntity();
		OrderEntity order = new OrderEntity();
		address.setId((long)10);
		address.setStreet("Blackstreet");
		address.setArea("Applepark");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(561234);
		
		order.setId((long)100);
		order.setAmount((double)25.36);
		order.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer.setId((long)1);
		customer.setName("Arjuna");
		customer.setEmail("Panadava3@gmail.com");
		customer.setContactNo("9512357468");
		customer.setDoB(LocalDate.parse("21/10/1997"));
		customer.setAddressEntity((List<AddressEntity>)address);
		customer.setOrderEntity((List<OrderEntity>) order);
		
		CustomerEntity saveInDb = testEntityManager.persist(customer);
		CustomerEntity getInDb = iCustomerRepository.findById(customer.getId()).get();
		assertThat(getInDb).isEqualTo(saveInDb);
	}
	
	@Test
	public void testgetAllCustomer() throws Exception
	{
		CustomerEntity customer1 = new CustomerEntity();
		AddressEntity address1 = new AddressEntity();
		OrderEntity order1 = new OrderEntity();
		address1.setId((long)10);
		address1.setStreet("Blackstreet");
		address1.setArea("Applepark");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(561234);
		
		order1.setId((long)100);
		order1.setAmount((double)25.36);
		order1.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9512357468");
		customer1.setDoB(LocalDate.parse("21/10/1997"));
		customer1.setAddressEntity((List<AddressEntity>)address1);
		customer1.setOrderEntity((List<OrderEntity>)order1);
		
		CustomerEntity customer2 = new CustomerEntity();
		AddressEntity address2 = new AddressEntity();
		OrderEntity order2 = new OrderEntity();
		address2.setId((long)20);
		address2.setStreet("Whitestreet");
		address2.setArea("Orangepark");
		address2.setCity("Mysore");
		address2.setState("Karnataka");
		address2.setPincode(561235);
		
		order2.setId((long)200);
		order2.setAmount((double)52.63);
		order2.setBillingDate(LocalDate.parse("01/05/2020"));
		
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("19/12/1998"));
		customer2.setAddressEntity((List<AddressEntity>) address2);
		customer2.setOrderEntity((List<OrderEntity>) order2);
		
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);
		
		List<CustomerEntity> customerlist = (List<CustomerEntity>) iCustomerRepository.findAll();
		
		Assert.assertEquals(2, customerlist.size());
	}
	
	@Test
	public void testremoveCustomer() throws Exception
	{
		CustomerEntity customer1 = new CustomerEntity();
		AddressEntity address1 = new AddressEntity();
		OrderEntity order1 = new OrderEntity();
		address1.setId((long)10);
		address1.setStreet("Blackstreet");
		address1.setArea("Applepark");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(561234);
		
		order1.setId((long)100);
		order1.setAmount((double)25.36);
		order1.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9851235467");
		customer1.setDoB(LocalDate.parse("21/10/1997"));
		customer1.setAddressEntity((List<AddressEntity>) address1);
		customer1.setOrderEntity((List<OrderEntity>) order1);
		
		CustomerEntity customer = testEntityManager.persist(customer1);
		testEntityManager.remove(customer);
		
		List<CustomerEntity> customerlist = (List<CustomerEntity>) iCustomerRepository.findAll();
		
		Assert.assertEquals(customerlist.size(), 1);
	}
	
	@Test
	public void testupdateCustomer() throws Exception
	{
		CustomerEntity customer2 = new CustomerEntity();
		AddressEntity address2 = new AddressEntity();
		OrderEntity order2 = new OrderEntity();
		address2.setId((long)20);
		address2.setStreet("Whitestreet");
		address2.setArea("Orangepark");
		address2.setCity("Mysore");
		address2.setState("Karnataka");
		address2.setPincode(561235);
		
		order2.setId((long)200);
		order2.setAmount((double)52.63);
		order2.setBillingDate(LocalDate.parse("01/05/2020"));
		
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("19/12/1998"));
		customer2.setAddressEntity((List<AddressEntity>) address2);
		customer2.setOrderEntity((List<OrderEntity>) order2);
		
		testEntityManager.persist(customer2);
		
		CustomerEntity getFromDb = iCustomerRepository.findById(customer2.getId()).get();
		getFromDb.setName("Bheemasena");
		testEntityManager.persist(getFromDb);
		
		assertThat(getFromDb.getName()).isEqualTo("Bheemasena");
	}
	
	@Test
	public void testAddCustomer() throws Exception
	{
		CustomerEntity customer = new CustomerEntity();
		AddressEntity address = new AddressEntity();
		OrderEntity order = new OrderEntity();
		address.setId((long)10);
		address.setStreet("Blackstreet");
		address.setArea("Applepark");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(561234);
		
		order.setId((long)100);
		order.setAmount((double)25.36);
		order.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer.setId((long)1);
		customer.setName("Arjuna");
		customer.setEmail("Panadava3@gmail.com");
		customer.setContactNo("9512357468");
		customer.setDoB(LocalDate.parse("21/10/1997"));
		customer.setAddressEntity((List<AddressEntity>)address);
		customer.setOrderEntity((List<OrderEntity>) order);
		
		CustomerEntity saveToDb = testEntityManager.persist(customer);
		CustomerEntity getFromDb = iCustomerRepository.findById(saveToDb.getId()).get();
		assertEquals(getFromDb, saveToDb);
	}
	
}
