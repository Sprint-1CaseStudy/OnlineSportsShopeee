package com.example.onlinesportshopee.services;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.controller.CartController;
import com.example.onlinesportshopee.dao.ICartRepository;
import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.CartException;
import com.example.onlinesportshopee.model.Cart;
import com.example.onlinesportshopee.util.CartUtils;


@Service
public class CartServiceImpl implements ICartService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired 
	private ICartRepository iCartRepository;
	
	@Autowired 
	private IProductRepository iProductRepository;
	
	@Override
	public Cart addCart(Long ProdId) throws CartException {
		LOGGER.info("addtocart() service is initiated");
		ProductEntity proEntity = iProductRepository.findById(ProdId).get();
		CartEntity carEntity = null;
		if(proEntity==null)
			carEntity=null;
		else {
			CartEntity cartEntity = new CartEntity(proEntity.getProductName(),1,proEntity.getMrp(),proEntity.getPriceAfterDiscount());
			carEntity = iCartRepository.save(cartEntity);
		}
		LOGGER.info("addtocart() service has Executed");
		return CartUtils.convertToCart(carEntity);
	}

	@Override
	public Cart deleteCart(Long id) throws CartException {
		LOGGER.info("deletecart() service is initiated");
		CartEntity carEntity = iCartRepository.findById(id).orElse(null);
		if (carEntity == null)
			throw new CartException("CartNotFound");
		else
			iCartRepository.delete(carEntity);
		LOGGER.info("deletecart() service has Executed");
		return CartUtils.convertToCart(carEntity);
	}


	@Override
	public List<Cart> getallCartDetails() {
		LOGGER.info("getallcartdetails() service is initiated");
		List<CartEntity> carList = iCartRepository.findAll();
		LOGGER.info("getallcartdetails() has Executed");
		return CartUtils.convertToCartDtoList(carList);
	}

}
