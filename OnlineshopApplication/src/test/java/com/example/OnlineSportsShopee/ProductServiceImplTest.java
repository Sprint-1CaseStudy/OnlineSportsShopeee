package com.example.OnlineSportsShopee;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.ProductNotFoundException;
import com.example.onlinesportshopee.services.IProductService;

@SpringBootTest
class ProductServiceImplTest {

	@Autowired
	IProductService productService;
	
	ProductEntity productEntity = null;
	CartEntity cartEntity = null;
	PaymentEntity paymentEntity = null;
	CustomerEntity customerEntity = null;
	OrderEntity orderEntity = null;
	
	@BeforeAll
	public static void beforeAll() {
		
	}
	
	@Test
	void testAddProduct01() throws ProductNotFoundException {
		
	}
	
	@AfterAll
	public static void end() {
		
	}

}