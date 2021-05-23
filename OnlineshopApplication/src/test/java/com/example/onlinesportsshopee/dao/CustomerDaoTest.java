package com.example.onlinesportsshopee.dao;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
//
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.CustomerEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootConfiguration
@EnableJpaRepositories(basePackages = {"com.example.onlinesportsshopee.*"})
class CustomerDaoTest {

	@Autowired
	private ICustomerRepository iCustomerRepository;
	
	@Autowired 
	private TestEntityManager testEntityManager;
	
	public CustomerEntity testgetCustomer() throws Exception
	{
		CustomerEntity customer = new CustomerEntity();
		//customer.setId(1);
		customer.setName("Arjuna");
		customer.setEmail("Panadava3@gmail.com");
		customer.setContactNo("9512357468");
		customer.setDoB(LocalDate.parse("1997-10-21"));
		return customer; 
	}
	
	@Test
	void testgetAllCustomer() throws Exception
	{
		CustomerEntity customer1 = new CustomerEntity();		
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9512357468");
		customer1.setDoB(LocalDate.parse("1997-10-21"));
		
		CustomerEntity customer2 = new CustomerEntity();
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("1998-12-19"));
		
		testEntityManager.persist(customer1);
		testEntityManager.persist(customer2);
		
		List<CustomerEntity> customerlist = (List<CustomerEntity>) iCustomerRepository.findAll();
		
		Assert.assertEquals(2, customerlist.size());
	}
	
	@Test
	void testremoveCustomer() throws Exception
	{
		CustomerEntity customer1 = new CustomerEntity();
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9851235467");
		customer1.setDoB(LocalDate.parse("1997-10-21"));
		
		CustomerEntity customer = testEntityManager.persist(customer1);
		testEntityManager.remove(customer);
		
		List<CustomerEntity> customerlist = (List<CustomerEntity>) iCustomerRepository.findAll();
		
		Assert.assertEquals(customerlist.size(), 1);
	}
	
	@Test
	void testupdateCustomer() throws Exception
	{
		CustomerEntity customer2 = new CustomerEntity();
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("1998-12-19"));
		
		testEntityManager.persist(customer2);
		
		CustomerEntity getFromDb = iCustomerRepository.findById((long)2).get();
		getFromDb.setName("Bheemasena");
		testEntityManager.persist(getFromDb);
		
		Assert.assertEquals(getFromDb.getName(),"Bheemasena");
	}
	
	@Test
	void testAddCustomer() throws Exception
	{
		CustomerEntity customer = new CustomerEntity();
		
		CustomerEntity saveToDb = testEntityManager.persist(customer);
		CustomerEntity getFromDb = iCustomerRepository.findById(saveToDb.getId()).get();
		assertEquals(getFromDb, saveToDb);
	}
	
}
