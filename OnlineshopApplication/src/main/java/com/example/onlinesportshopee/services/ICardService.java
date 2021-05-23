package com.example.onlinesportshopee.services;

import java.util.List;

import com.example.onlinesportshopee.entities.CardEntity;
import com.example.onlinesportshopee.model.Card;

public interface ICardService {
	
	public Card addCard(Card card);
	public Card removeCard(Long id);
	public Card updateCard(Long id, Card card);
	public Card getCardDetails(Long id);
	public List<Card> getAllCards();

}
