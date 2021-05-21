package com.example.onlinesportshopee.services;

import java.util.List;

import com.example.onlinesportshopee.entities.CardEntity;
import com.example.onlinesportshopee.model.Card;

public interface ICardService {
	
	public Card addCard(CardEntity card);
	public Card removeCard(long id);
	public Card updateCard(long id, CardEntity card);
	public Card getCardDetails(long id);
	public List<Card> getAllCards();

}
