package com.example.onlinesportshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.example.onlinesportshopee.entities.CardEntity;

import com.example.onlinesportshopee.model.Card;




public class CardUtils {
	private CardUtils(){
		
	}
	
	public static List<Card> convertToCardList(List<CardEntity> list){
		List<Card> cardlist = new ArrayList<>();
		for(CardEntity cardEntity : list) 
			cardlist.add(convertToCard(cardEntity));
		return cardlist;
	}
	public static CardEntity convertToCard(Card cardList) {
		 CardEntity card= new CardEntity();
		 card.setId(cardList.getId());
		 card.setCardName(cardList.getCardName());
	     card.setCardNumber(cardList.getCardNumber());
	     card.setExpiryDate(cardList.getCardExpiry());
	     card.setBankName(cardList.getBankName());
	     card.setPaymentEntity(cardList.getPaymentEntity());
	     return card;
	    } 
	 public static Card convertToCard(CardEntity cardEntity) {
	        Card card = new Card();
	        card.setId(cardEntity.getId());
	        card.setCardName(cardEntity.getCardName());
	        card.setCardNumber(cardEntity.getCardNumber());
	        card.setCardExpiry(cardEntity.getExpiryDate());
	        card.setBankName(cardEntity.getBankName());
	        card.setPaymentEntity(cardEntity.getPaymentEntity()); 
	        return card;
	
	 }
	

}