package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.onlinesportshopee.dao.ICartRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.exception.CartException;
import com.example.onlinesportshopee.services.ICartService;


class CartServiceImplTest {

	@MockBean
	ICartRepository icartdao;
	
	
	@Autowired
	ICartService icartservice;
	
	CartEntity cart=null;
	
	@Test
	void testAddCart01() throws CartException
	{
		cart = new CartEntity();
		cart.setId((long)5);
		cart.setImageName("shoe");
		cart.setPrice(500.36);
		cart.setProductName("nike");
		cart.setQuantity(1);
		cart.setTotal(450.00);
		
		
		Mockito.when(icartdao.saveAndFlush(cart)).thenReturn(cart);
		assertThat(icartservice.addCart(cart)).isEqualTo(cart);
	}
	
	@Test
	void testdeleteCart01() throws CartException
	{
		cart = new CartEntity();
		cart.setId(null);
		cart.setImageName(null);
		cart.setPrice(null);
		cart.setProductName(null);
		cart.setQuantity(null);
		cart.setTotal(null);
		
		Mockito.when(icartdao.save(cart)).thenReturn(cart);
		icartdao.deleteById(cart.getId());
		assertNotEquals(cart, new CartEntity());
	}
	
	@Test
	void testgetcart01() throws CartException
	{
		cart = new CartEntity();
		cart.setId(null);
		cart.setImageName(null);
		cart.setPrice(null);
		cart.setProductName(null);
		cart.setQuantity(null);
		cart.setTotal(null);
		
		List<CartEntity> list = null;
		
		Mockito.when(icartdao.findAll()).thenReturn(list);
		
		//Mockito.when(iuserdao.findById(user.getId()).get()).thenReturn(user);
		//user.setPassword("chakri@456");
		//Mockito.when(iuserdao.save(user)).thenReturn(user);
		//assertThat(iuserservice.changePassword((long)1,user)).isEqualTo(user);
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
