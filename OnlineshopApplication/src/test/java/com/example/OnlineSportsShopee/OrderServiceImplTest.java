package com.example.OnlineSportsShopee;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
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
	OrderEntity order;

	@BeforeAll
	public static void init() {
		LOGGER.info("Order Testing Initiated");
	}
	
	@Test
	void testAddOrder1()throws OrderNotFoundException,InvalidOrderIdException{
		custent=new CustomerEntity((long)1,"Rama","rama@gmail.com","9873562781",LocalDate.parse("1995-09-30"),addent,ordent);
		proent=new ProductEntity((long)3," ankit", "women", "shop women shoe", "Nike","black", "7",1799.29,1699.12, true,order, LocalDate.parse("2021-06-11"),cartent);
		

	}

}
