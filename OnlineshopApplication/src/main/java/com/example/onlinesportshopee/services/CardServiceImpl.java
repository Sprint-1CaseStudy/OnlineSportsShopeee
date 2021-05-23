package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.ICardRepository;
import com.example.onlinesportshopee.entities.CardEntity;
import com.example.onlinesportshopee.model.Card;
import com.example.onlinesportshopee.util.CardUtils;

@Service
public class CardServiceImpl implements ICardService{
	
	static final Logger LOGGER = LoggerFactory.getLogger(CardServiceImpl.class);
	
	static String cardNotFound = "No card found in given Id";
	
	static String validateSuccessful = "Validation Successful";
	
	@Autowired
	private ICardRepository cardRepository;
	
	@Override
	public Card addCard(Card card) {
		LOGGER.info("addCard() service is initiated");
		CardEntity cardentity = CardUtils.convertToCard(card);
		CardEntity addCard = cardRepository.save(cardentity);
		LOGGER.info("addCard() service has executed");
		return CardUtils.convertToCard(addCard);
	}

	@Override
	public Card removeCard(Long id) {
		LOGGER.info("removeCard() service is initiated");
	    CardEntity deleteCard = cardRepository.findById(id).get();
	    cardRepository.delete(deleteCard);
	    LOGGER.info("removeCard() service has executed");
	return CardUtils.convertToCard(deleteCard);
	}

	@Override
	public Card updateCard(Long id, Card card) {
		LOGGER.info("updateCard() service is initiated");
		CardEntity cardentity = CardUtils.convertToCard(card);
		CardEntity updateCard = cardRepository.findById(id).get();
		updateCard = cardRepository.save(cardentity);
		LOGGER.info("updateCard() service has executed");
		return CardUtils.convertToCard(updateCard);
	}

	@Override
	public Card getCardDetails(Long id) {
		LOGGER.info("getCardDetails() service is initiated");
		CardEntity getCardDetails = cardRepository.findById(id).get();
		LOGGER.info("getCardDetails() service has executed");
		return CardUtils.convertToCard(getCardDetails);
	}

	@Override
	public List<Card> getAllCards() {
		LOGGER.info("getAllCards() service is initiated");
		List<CardEntity> getAllCards = cardRepository.findAll();
		LOGGER.info("getAllCards() service has executed");
		return CardUtils.convertToCardList(getAllCards);
	}	

}
