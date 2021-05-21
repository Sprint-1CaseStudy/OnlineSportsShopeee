package com.example.onlinesportshopee.model;

import java.util.List;

import com.example.onlinesportshopee.entities.CardEntity;

public class Payment {

	private Long paymentId;
	private String type;
	private String status;
	private List<CardEntity> cards;

	public Payment() {
		super();
	}
	
	public Payment(Long paymentId, String type, String status, List<CardEntity> cards) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.cards = cards;
	}

	public Long getPaymentId() {
		return paymentId;
	}
	
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<CardEntity> getCardEntity() {
		return cards;
	}

	public void setCardEntity(List<CardEntity> cards) {
		this.cards = cards;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", cards=" + cards + "]";
	}

	
	
}
