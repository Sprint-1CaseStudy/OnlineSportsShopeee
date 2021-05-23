package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.ICartRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.CartException;
import com.example.onlinesportshopee.exception.InvalidCustomerIdException;
import com.example.onlinesportshopee.services.CartServiceImpl;
import com.example.onlinesportshopee.services.ICartService;

import org.junit.jupiter.api.Test;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartServiceImpl.class)
class CartServiceImplTest {
	
	@MockBean
	ICartRepository iCartRepository;
	
	@Autowired
	ICartService iCartService;
	
	@Test
	void testaddCart01() throws CartException,InvalidCustomerIdException {
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
		
		CartEntity cartEntity = new CartEntity();
		cartEntity.setId((long)121);
		cartEntity.setPrice(productEnt.getMrp());
		cartEntity.setProductName(productEnt.getProductName());
		cartEntity.setQuantity(1);
		cartEntity.setTotal(productEnt.getPriceAfterDiscount());
		
		Mockito.when(iCartRepository.save(cartEntity)).thenReturn(cartEntity);
		assertNotNull(cartEntity);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
