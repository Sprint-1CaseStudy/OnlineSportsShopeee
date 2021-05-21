package com.example.onlinesportshopee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.exception.CartException;
import com.example.onlinesportshopee.model.Cart;
import com.example.onlinesportshopee.services.ICartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/addtocart")
	public  ResponseEntity<Object> addtocart(@RequestBody CartEntity cartEntity) throws CartException{
		LOGGER.info("add-cart URL is opened");
		LOGGER.info("addtocart() is initiated");
		Cart cartDTO = null;
		ResponseEntity<Object> cartResponse = null;
		cartDTO = cartService.addCart(cartEntity);
		cartResponse = new ResponseEntity<>(cartDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addtocart() has Executed");
		return cartResponse;
	}
	
	@DeleteMapping("/removefromcart/{delID}")
	public ResponseEntity<Object> deletecart(@PathVariable long delID)throws CartException{
		LOGGER.info("remove-cart URL is opened");
		LOGGER.info("deletecart() is initiated");
		Cart cartDTO = cartService.deleteCart(delID);
		ResponseEntity<Object> cartResponse = new ResponseEntity<>(cartDTO, HttpStatus.ACCEPTED);
		LOGGER.info("deletecart() has Executed");
		return cartResponse;

	}
	
	@GetMapping("/getallcartdetials")
	public List<Cart> getAllProduct()
	{
		LOGGER.info("getall-cartdetails URL is opened");
		LOGGER.info("getallcartdetails() initiated");
		return cartService.getallCartDetails();
	}
}
