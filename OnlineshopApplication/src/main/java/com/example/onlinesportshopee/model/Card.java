package com.example.onlinesportshopee.model;

import java.time.LocalDate;

import com.example.onlinesportshopee.entities.PaymentEntity;


public class Card {
	private Long id;
	private String cardName;
	private String cardNumber;
    private LocalDate cardExpiry;
    private String bankName;
    private PaymentEntity paymentEntity;
    
   public Card() {
	   
   }
   public Card(Long id, String cardName, String cardNumber, LocalDate cardExpiry, String bankName,PaymentEntity paymentEntity) {
    	super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.bankName = bankName;
		this.paymentEntity = paymentEntity;
    }
    
    public Long getId() {
		return id;
	}
    public void setId(Long id) {
		this.id = id;
	}
    public String getCardName() {
		return cardName;
	}
	
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public PaymentEntity getPaymentEntity() {
		return paymentEntity;
	}
	public void setPaymentEntity(PaymentEntity paymentEntity) {
		this.paymentEntity = paymentEntity;
	}
	
    @Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry
				+ ", bankName=" + bankName + ", paymentEntity=" + paymentEntity + "]";
	}
	

}
