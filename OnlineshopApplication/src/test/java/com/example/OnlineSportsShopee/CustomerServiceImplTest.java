package com.example.OnlineSportsShopee;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.exception.InvalidCustomerIdException;
import com.example.onlinesportshopee.model.Customer;
import com.example.onlinesportshopee.services.ICustomerService;
import java.util.List;


@SpringBootTest
class CustomerServiceImplTest {

	final static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImplTest.class);
	
	@Autowired
	ICustomerService icustomerservice;
	
	AddressEntity addressentity;
	OrderEntity orderentity;
	CustomerEntity customerentity;
	List<OrderEntity> orderlist = null;
	List<AddressEntity> addresslist = null;
	List<ProductEntity> productlist = null;
	PaymentEntity paymententity;
	
	@BeforeAll
	public static void init()
	{
		LOGGER.info("Customer Testing Initiated");
	}
	
	@Test
	void testaddCustomer01() throws CustomerNotFoundException,InvalidCustomerIdException {
		addressentity = new AddressEntity((long) 1, "street", "area", "city","state", (int)846532, customerentity);
		orderentity = new OrderEntity((long) 1, (double) 25.22, LocalDate.parse("14/05/2021"), customerentity, productlist, "card", paymententity );
		try {
			icustomerservice.addCustomer(customerentity);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testaddCustomer02() throws CustomerNotFoundException,InvalidCustomerIdException {
		addressentity = new AddressEntity((long) 3, "power street", "Whitefeild", "Bangalore","Karnataka", (int)654893, customerentity);
		orderentity = new OrderEntity((long) 3, (double) 55.66, LocalDate.parse("11/06/2021"), customerentity, productlist, "Netbanking", paymententity );
		try {
			icustomerservice.addCustomer(customerentity);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testremoveCustomer01() throws InvalidCustomerIdException {
		LOGGER.info("Testing testremoveCustomer01()");
		try {
			icustomerservice.removeCustomer(1);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testremoveCustomer02() throws InvalidCustomerIdException {
		LOGGER.info("Testing testremoveCustomer02()");
		try {
			icustomerservice.removeCustomer(1);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testUpdateCustomer01() throws CustomerNotFoundException,InvalidCustomerIdException {
		LOGGER.info("Testing TestUpdateCustomer01()");
		addressentity = new AddressEntity((long) 1, "teerts", "aera", "ytic","etats", (int)235648, customerentity);
		orderentity = new OrderEntity((long) 1, (double) 22.52, LocalDate.parse("21/08/14"), customerentity, productlist, "netbanking", paymententity );
		try {
			icustomerservice.updateCustomer(1,customerentity);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testUpdateCustomer02() throws CustomerNotFoundException,InvalidCustomerIdException {
		LOGGER.info("Testing TestUpdateCustomer02()");
		addressentity = new AddressEntity((long) 3, "cover street", "Blackfeild", "Mysore","Karnataka", (int)398456, customerentity);
		orderentity = new OrderEntity((long) 3, (double) 66.55, LocalDate.parse("21/06/2011"), customerentity, productlist, "card", paymententity );
		try {
			icustomerservice.updateCustomer(3,customerentity);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testgetCustomer01() throws InvalidCustomerIdException {
		LOGGER.info("Testing testgetCustomer01()");
		try {
			icustomerservice.getCustomer(5);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testgetCustomer02() throws InvalidCustomerIdException {
		LOGGER.info("Testing testgetCustomer01()");
		try {
			icustomerservice.getCustomer(7);
		} catch (CustomerNotFoundException exception) {
			assertEquals("CUSTOMER NOT FOUND", exception.getMessage());
		}
	}
	
	@Test
	void testgetAllCustomers01() {
		assertNotNull(icustomerservice.getAllCustomers());
	}
	
	@Test
	void testgetAllCustomers02() {
		try {
			assertNull(icustomerservice.getAllCustomers());
		} catch(AssertionFailedError exception) {
			assertNotNull(icustomerservice.getAllCustomers());
		}
	}
	
	@AfterAll
	public static void end() {
		LOGGER.info("Customer Testing Terminated");
	}

}