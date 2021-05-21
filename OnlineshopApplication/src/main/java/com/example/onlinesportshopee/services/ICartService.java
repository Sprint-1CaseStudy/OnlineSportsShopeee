package com.example.onlinesportshopee.services;

import java.util.List;


import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.exception.CartException;
import com.example.onlinesportshopee.model.Cart;



public interface ICartService {
	
		public Cart addCart(CartEntity cartEntity) throws CartException;
		public Cart deleteCart(long id) throws CartException;
		public List<Cart> getallCartDetails();

}
