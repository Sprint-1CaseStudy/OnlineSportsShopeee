package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.controller.CartController;
import com.example.onlinesportshopee.dao.ICartRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.exception.CartException;
import com.example.onlinesportshopee.model.Cart;
import com.example.onlinesportshopee.util.CartUtils;


@Service
public class CartServiceImpl implements ICartService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@Autowired 
	private ICartRepository iCartRepository; 
	
	@Override
	public Cart addCart(CartEntity cartEntity) throws CartException {
		LOGGER.info("addtocart() service is initiated");
		CartEntity carEntity = null;
		if(cartEntity==null)
			carEntity=null;
		else {
			carEntity = iCartRepository.save(cartEntity);
		}
		LOGGER.info("addtocart() service has Executed");
		return CartUtils.convertToOrder(carEntity);
	}

	@Override
	public Cart deleteCart(long id) throws CartException {
		LOGGER.info("deletecart() service is initiated");
		CartEntity carEntity = iCartRepository.findById(id).orElse(null);
		if (carEntity == null)
			throw new CartException("CartNotFound");
		else
			iCartRepository.delete(carEntity);
		LOGGER.info("deletecart() service has Executed");
		return CartUtils.convertToOrder(carEntity);
	}


	@Override
	public List<Cart> getallCartDetails() {
		LOGGER.info("getallcartdetails() service is initiated");
		List<CartEntity> carList = iCartRepository.findAll();
		LOGGER.info("getallcartdetails() has Executed");
		return CartUtils.convertToOrderDtoList(carList);
	}

}
