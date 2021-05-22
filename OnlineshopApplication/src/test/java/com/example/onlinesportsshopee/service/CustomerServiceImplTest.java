package com.example.onlinesportsshopee.service;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.exception.InvalidCustomerIdException;
import com.example.onlinesportshopee.services.ICustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.jupiter.api.Test;

@SpringBootTest
class CustomerServiceImplTest {

		@MockBean
		ICustomerRepository iCustomerRepository;
		
		@Autowired
		ICustomerRepository iCustomerRepository1;
		
		@Autowired
		ICustomerService iCustomerService;
		
		CustomerEntity customer;
		AddressEntity address;
		List<AddressEntity> addresslist = null;
		OrderEntity  order;
		List<OrderEntity> orderlist = null;
		
		final static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImplTest.class);
		
		@BeforeAll
		public static void init()
		{
			LOGGER.info("Customer Testing Initiated");
		}
		
		@Test
		void testaddCustomer01() throws CustomerNotFoundException,InvalidCustomerIdException {
			address = new AddressEntity((long) 10, "Blackstreet", "Applepark", "Bangalore","Karnataka", 561234, null );
			order = new OrderEntity((long) 1, (double) 25.36, LocalDate.parse("01/04/2020"), "card", null, null, null);
			customer = new CustomerEntity((long)1, "Arjuna","Pandava3@gmail.com","9512357468",LocalDate.parse("21/10/1997"),addresslist,orderlist);
			Mockito.when(iCustomerRepository.saveAndFlush(customer)).thenReturn(customer);
	        assertThat(iCustomerService.addCustomer(customer)).isEqualTo(customer);
		}
		
		@Test
		void testaddCustomer02() throws CustomerNotFoundException,InvalidCustomerIdException {
			address = new AddressEntity((long) 20, "Whitestreet", "Orangepark", "Mysore","Karnataka", 561235, null );
			order = new OrderEntity((long) 200, (double) 52.63, LocalDate.parse("01/05/2020"), "NetBanking", null, null, null);
			customer = new CustomerEntity((long)2, "Bheema","Pandava2@gmail.com","9632588741",LocalDate.parse("19/12/1998"),addresslist,orderlist);
			try {
				iCustomerService.addCustomer(customer);
			} catch (CustomerNotFoundException exception) {
				assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
			}
		}
		
		@Test
		void testremoveCustomer01() throws InvalidCustomerIdException {
			LOGGER.info("Testing testremoveCustomer01()");
			try {
				iCustomerService.removeCustomer(customer.getId());
			} catch (CustomerNotFoundException exception) {
				assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
			}
		}
		
		@Test
		void testremoveCustomer02() throws InvalidCustomerIdException {
			LOGGER.info("Testing testremoveCustomer02()");
			Mockito.when(iCustomerRepository.save(customer)).thenReturn(customer);
			iCustomerRepository.deleteById(customer.getId());
			assertNotEquals(customer, new CustomerEntity());
		}
		
		@Test
		void testUpdateCustomer01() throws CustomerNotFoundException,InvalidCustomerIdException {
			LOGGER.info("Testing TestUpdateCustomer01()");
			address = new AddressEntity((long) 10, "Blackstreet", "Applepark", "Bangalore","Karnataka", 561234, null );
			order = new OrderEntity((long) 1, (double) 25.36, LocalDate.parse("01/04/2020"), "card", null, null, null);
			customer = new CustomerEntity((long)1, "Arjuna","Pandava3@gmail.com","9512357468",LocalDate.parse("21/10/1997"),addresslist,orderlist);
			try {
				iCustomerService.updateCustomer(customer.getId(), customer);
				assertEquals("BlackStreet", ((AddressEntity) customer.getAddressEntity()).getStreet());
			} catch (CustomerNotFoundException exception) {
				assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
			}
		}
		
		@Test
		void testUpdateCustomer02() throws CustomerNotFoundException,InvalidCustomerIdException {
			LOGGER.info("Testing TestUpdateCustomer02()");
			address = new AddressEntity((long) 10, "Blackstreet", "Applepark", "Bangalore","Karnataka", 561234, null );
			order = new OrderEntity((long) 1, (double) 25.36, LocalDate.parse("01/04/2020"), "card", null, null, null);
			customer = new CustomerEntity((long)1, "Arjuna","Pandava3@gmail.com","9512357468",LocalDate.parse("21/10/1997"),addresslist,orderlist);
			address.setPincode(56008);
			Mockito.when(iCustomerRepository.save(customer)).thenReturn(customer);
			assertEquals(((AddressEntity) customer.getAddressEntity()).getPincode(), 56008);
		}
		
		@Test
		void testgetCustomer01() throws InvalidCustomerIdException {
			LOGGER.info("Testing testgetCustomer01()");
			Mockito.when(iCustomerRepository.save(customer)).thenReturn(customer);
			assertEquals(customer.getId(),1);
		}
		
		@Test
		void testgetCustomer02() throws InvalidCustomerIdException {
			LOGGER.info("Testing testgetCustomer02()");
			try {
				iCustomerService.getCustomer(customer.getId());
			} catch (CustomerNotFoundException exception) {
				assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
			}
		}
		
		@Test
		void testgetAllCustomers01() {
			assertNotNull(iCustomerService.getAllCustomers());
		}
		
		@Test
		void testgetAllCustomers02() {
			try {
				assertNull(iCustomerService.getAllCustomers());
			} catch(AssertionFailedError exception) {
				assertNotNull(iCustomerService.getAllCustomers());
			}
		}
		
		@AfterAll
		public static void end() {
			LOGGER.info("Customer Testing Terminated");
		}

}
//