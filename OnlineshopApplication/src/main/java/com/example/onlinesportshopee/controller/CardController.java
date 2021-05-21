package com.example.onlinesportshopee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinesportshopee.entities.CardEntity;

import com.example.onlinesportshopee.exception.CardNotFoundException;

import com.example.onlinesportshopee.model.Card;

import com.example.onlinesportshopee.services.CardServiceImpl;

@RestController
@RequestMapping("/onlinesportshopee")
public class CardController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);
	
	@Autowired
	private CardServiceImpl cardServiceImpl;
	
	@PostMapping("/cards/add-card")
	public ResponseEntity<Object> addCard(@RequestBody CardEntity card) throws CardNotFoundException
	{
		LOGGER.info("add-card URL is opened");
		LOGGER.info("addCard() is initiated");
		Card cardDto = null;
		ResponseEntity<Object> cardResponse = null;
		cardDto = cardServiceImpl.addCard(card);
		cardResponse = new ResponseEntity<>(cardDto, HttpStatus.ACCEPTED);
		LOGGER.info("addCard() has executed");
		return cardResponse;
	}

	@DeleteMapping("/cards/remove-card/card/{id}")
	public ResponseEntity<Object> removeCard(@PathVariable long id) throws CardNotFoundException
	{
		LOGGER.info("remove-card URL is opened");
		LOGGER.info("removeCard() is initiated");
		Card cardDto = null;
		ResponseEntity<Object> cardResponse = null;
		cardDto = cardServiceImpl.removeCard(id);
		cardResponse = new ResponseEntity<>(cardDto, HttpStatus.ACCEPTED);
		LOGGER.info("removeCard() has executed");
		return cardResponse;
	 
	}
	
	@PutMapping("/cards/update-card/{id}")
	public ResponseEntity<Object> updateCard(@PathVariable long id, @RequestBody CardEntity card)
	{
		LOGGER.info("update-card URL is opened");
		LOGGER.info("updateCard() is initiated");
		Card cardDto = null;
		ResponseEntity<Object> cardResponse = null;
		cardDto = cardServiceImpl.updateCard(id, card);
		cardResponse = new ResponseEntity<>(cardDto, HttpStatus.ACCEPTED);
		LOGGER.info("updateCard() has executed");
		return cardResponse;
		
	}
	@GetMapping("/cards/get-card-details/{id}")
	public ResponseEntity<Object> getCardDetails(@PathVariable long id)
	{
		LOGGER.info("get-card-details URL is opened");
		LOGGER.info("getCardDetails() is initiated");
		Card cardDto = null;
		ResponseEntity<Object> cardResponse = null;
		cardDto = cardServiceImpl.getCardDetails(id);
		cardResponse = new ResponseEntity<>(cardDto, HttpStatus.ACCEPTED);
		LOGGER.info("getCardDetails() has executed");
		return cardResponse;
	}
	
	@GetMapping("/cards/get-all-cards")

	public List<Card> getAllCards()
	{
		LOGGER.info("get-all-cards URL is opened");
		LOGGER.info("getAllCards() is initiated");
		LOGGER.info("getAllCards() has executed");
		return cardServiceImpl.getAllCards();
	}
	
}
