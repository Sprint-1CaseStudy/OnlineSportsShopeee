package com.example.onlinesportsshopee.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.CustomerEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerDaoTest {

	@Autowired
	private ICustomerRepository iCustomerRepository;
	
	@Autowired 
	private TestEntityManager testEntityManager;
	
	
	public CustomerEntity testgetCustomer()
	{
		CustomerEntity customer = new CustomerEntity();
		//customer.setId(1);
		customer.setName("Arjuna");
		customer.setEmail("Panadava3@gmail.com");
		customer.setContactNo("9512357468");
		customer.setDoB(LocalDate.parse("21/10/1997"));
		return customer;
	}
	
	@Test
	public void testgetAllCustomer() throws Exception
	{
		CustomerEntity customer1 = new CustomerEntity();		
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9512357468");
		customer1.setDoB(LocalDate.parse("21/10/1997"));
		
		CustomerEntity customer2 = new CustomerEntity();
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("19/12/1998"));
		
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);
		
		List<CustomerEntity> customerlist = (List<CustomerEntity>) iCustomerRepository.findAll();
		
		Assert.assertEquals(2, customerlist.size());
	}
	
	@Test
	public void testremoveCustomer() throws Exception
	{
		CustomerEntity customer1 = new CustomerEntity();
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9851235467");
		customer1.setDoB(LocalDate.parse("21/10/1997"));
		
		CustomerEntity customer = testEntityManager.persist(customer1);
		testEntityManager.remove(customer);
		
		List<CustomerEntity> customerlist = (List<CustomerEntity>) iCustomerRepository.findAll();
		
		Assert.assertEquals(customerlist.size(), 1);
	}
	
	@Test
	public void testupdateCustomer() throws Exception
	{
		CustomerEntity customer2 = new CustomerEntity();
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("19/12/1998"));
		
		testEntityManager.persist(customer2);
		
		CustomerEntity getFromDb = iCustomerRepository.findById((long)2).get();
		getFromDb.setName("Bheemasena");
		testEntityManager.persist(getFromDb);
		
		Assert.assertEquals(getFromDb.getName(),"Bheemasena");
	}
	
	@Test
	public void testAddCustomer() throws Exception
	{
		CustomerEntity customer = new CustomerEntity();
		
		CustomerEntity saveToDb = testEntityManager.persist(customer);
		CustomerEntity getFromDb = iCustomerRepository.findById(saveToDb.getId()).get();
		assertEquals(getFromDb, saveToDb);
	}
	
}
