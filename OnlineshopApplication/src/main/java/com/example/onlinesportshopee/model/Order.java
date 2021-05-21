package com.example.onlinesportshopee.model;

import java.time.LocalDate;
import java.util.List;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;

public class Order {

	private Long orderID;
	private Double amount;
	private LocalDate billingDate;
	private String paymentMethod;
	private CustomerEntity customerEntity;
	private List<ProductEntity> productEntity;
	private PaymentEntity paymentEntity;
	
	
	public Order() {
		super();
	}

	public Order(Long orderID, Double amount, LocalDate billingDate, CustomerEntity customerEntity,
			String paymentMethod, List<ProductEntity> productEntity, PaymentEntity paymentEntity) {
		super();
		this.orderID = orderID;
		this.amount = amount;
		this.billingDate = billingDate;
		this.customerEntity = customerEntity;
		this.paymentMethod = paymentMethod;
		this.productEntity = productEntity;
		this.paymentEntity = paymentEntity;
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
	
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}
	
	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PaymentEntity getPaymentEntity() {
		return paymentEntity;
	}

	public void setPaymentEntity(PaymentEntity paymentEntity) {
		this.paymentEntity = paymentEntity;
	}

	public List<ProductEntity> getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(List<ProductEntity> productEntity) {
		this.productEntity = productEntity;
	}
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", amount=" + amount + ", billingDate=" + billingDate + ", customerEntity="
				+ customerEntity + ", paymentMethod=" + paymentMethod + ", productEntity=" + productEntity
				+ ", paymentEntity=" + paymentEntity + "]";
	}

}
