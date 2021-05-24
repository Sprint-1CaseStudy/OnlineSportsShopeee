package com.example.onlinesportshopee.model;

import java.time.LocalDate;
import java.util.List;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;

public class Order {

	private Long orderID;
	private Double amount;
	private LocalDate billingDate;
	private String paymentMethod;
	private CartEntity cartEntity;
	
	
	public Order() {
		super();
	}

	public Order(Long orderID, Double amount, LocalDate billingDate,
			String paymentMethod,CartEntity cartEntity) {
		super();
		this.orderID = orderID;
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.cartEntity=cartEntity;
	}
	
	public Long getOrderID() {
		return orderID;
	}
	
	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public LocalDate getBillingDate() {
		return billingDate;
	}
	
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	

	

	public CartEntity getCartEntity() {
		return cartEntity;
	}

	public void setCartEntity(CartEntity cartEntity) {
		this.cartEntity = cartEntity;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", amount=" + amount + ", billingDate=" + billingDate + ", paymentMethod="
				+ paymentMethod + ", cartEntity=" + cartEntity + "]";
	}

}
