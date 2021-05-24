package com.example.onlinesportshopee.entities;


import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "amount")
	private Double amount;
	@Column(name = "billingDate")
	private LocalDate billingDate;
    @Column(name = "paymentMethod")
	private String paymentMethod;
    @OneToOne(cascade = CascadeType.ALL)
	private CartEntity cartEntity;
	
	
	public OrderEntity(Long id, Double amount, LocalDate billingDate, String paymentMethod,CartEntity cartEntity) {
		super();
		this.id = id;
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.cartEntity=cartEntity;
		
		
	}


	public OrderEntity() {
		super();
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public CartEntity getCartEntity() {
		return cartEntity;
	}


	public void setCartEntity(CartEntity cartEntity) {
		this.cartEntity = cartEntity;
	}


	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", amount=" + amount + ", billingDate=" + billingDate + ", paymentMethod="
				+ paymentMethod + ", cartEntity=" + cartEntity + "]";
	}

	
	
}

	
	