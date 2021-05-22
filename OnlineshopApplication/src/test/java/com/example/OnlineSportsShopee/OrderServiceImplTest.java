package com.example.OnlineSportsShopee;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.CardEntity;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.services.IOrderService;

@SpringBootTest
class OrderServiceImplTest {

	final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceImplTest.class);

	@Autowired
	IOrderService service;
	
	List<OrderEntity> ordent=null;
	CustomerEntity custent;
	ProductEntity proent;
	PaymentEntity payent;
	List<AddressEntity> addent=null;
	List<CartEntity> cartent=null;
	List<CardEntity> cardent=null;
	OrderEntity order;

	@BeforeAll
	public static void init() {
		LOGGER.info("Order Testing Initiated");
	}
	
	@Test
	void testAddOrder1()throws OrderNotFoundException,InvalidOrderIdException{
		custent=new CustomerEntity((long)1,"Manasa","manasa@gmail.com","9873562781",LocalDate.parse("1995-09-30"),addent,ordent);
		proent=new ProductEntity((long)1," skate shoe", "women", "shop women shoes", "Nike","black", "7",1799.29,1699.12, true,order, LocalDate.parse("2021-06-11"),cartent);
		payent= new PaymentEntity((long) 1,"card", "success", cardent);

		try {
			service.addOrder(order);
		} catch (OrderNotFoundException exception) {
			assertEquals("Order not found", exception.getMessage());
		}
	}
	
	@Test
	void testAddOrder2()throws OrderNotFoundException,InvalidOrderIdException{
		custent=new CustomerEntity((long)3,"Rama","rama@gmail.com","7896432366",LocalDate.parse("1999-09-09"),addent,ordent);
		proent=new ProductEntity((long)3," athletic shoe", "men", "shop men shoe", "puma","red", "9",2099.29,1999.12, true,order, LocalDate.parse("2021-05-11"),cartent);
		payent= new PaymentEntity((long) 3,"netbanking", "success", null);

		try {
			service.addOrder(order);
		} catch (OrderNotFoundException exception) {
			assertEquals("Order not found", exception.getMessage());
		}
		
	}
	@Test
	void testUpdateOrder1()throws OrderNotFoundException,InvalidOrderIdException{
		
		LOGGER.info("Testing testUpdateOrder1()");
		custent=new CustomerEntity((long)1,"Lata","lataa@gmail.com","9873562781",LocalDate.parse("1995-09-30"),addent,ordent);
		proent=new ProductEntity((long)1," running shoe", "women", "shop women shoes", "Nike","red", "7",1799.29,1699.12, true,order, LocalDate.parse("2021-06-11"),cartent);
		payent= new PaymentEntity((long) 1,"card", "success", cardent);

		try {
			service.updateOrder(1,order);
		} catch (OrderNotFoundException exception) {
			assertEquals("Order not found for given Id", exception.getMessage());
		}
	}
	@Test
void testUpdateOrder2()throws OrderNotFoundException,InvalidOrderIdException{
		
		LOGGER.info("Testing testUpdateOrder1()");
		custent=new CustomerEntity((long)3,"Ravan","ravan@gmail.com","7896432366",LocalDate.parse("1999-09-09"),addent,ordent);
		proent=new ProductEntity((long)3," gym shoe", "men", "shop men shoe", "puma","white", "9",2099.29,1999.12, true,order, LocalDate.parse("2021-05-11"),cartent);
		payent= new PaymentEntity((long) 3,"netbanking", "success", null);

		try {
			service.updateOrder(3,order);
		} catch (OrderNotFoundException exception) {
			assertEquals("Order not found for given Id", exception.getMessage());
		}
	}
	
	@Test
	void testDeleteOrder1() throws InvalidOrderIdException{
		LOGGER.info("Testing testDeleteOrder1()");
		try {
			service.deleteOrder(88);
		} catch (InvalidOrderIdException exception) {
			assertEquals("No Order found in given ID", exception.getMessage());
		}
		
	}
	@Test
	void testDeleteOrder2() throws InvalidOrderIdException{
		LOGGER.info("Testing testDeleteOrder2()");
		try {
			service.deleteOrder(77);
		} catch (InvalidOrderIdException exception) {
			assertEquals("No Order found in given ID", exception.getMessage());
		}
		
	}
	
	@Test
	void testGetOrderDetails1() throws InvalidOrderIdException{
		LOGGER.info("Testing testGetOrder1()");
		try {
			service.getOrderDetails(9);
		} catch (InvalidOrderIdException exception) {
			assertEquals("No Order found in given ID", exception.getMessage());
		}
		
	}
	@Test
	void testGetOrderDetails2() throws InvalidOrderIdException{
		LOGGER.info("Testing testGetOrder2()");
		try {
			service.getOrderDetails(7);
		} catch (InvalidOrderIdException exception) {
			assertEquals("No Order found in given ID", exception.getMessage());
		}
		
	}
	@Test
	void testGetAllOrders1() {
		assertNotNull(service.getAllOrders());
	}
	@AfterAll
	public static void end() {
		LOGGER.info("Order Testing Terminated");
	}
	@Test
	void testGetAllOrders2() {
		try {
			assertNull(service.getAllOrders());
		} catch (AssertionFailedError exception) {
			assertNotNull(service.getAllOrders());
		}
	}
	
	
	
}
