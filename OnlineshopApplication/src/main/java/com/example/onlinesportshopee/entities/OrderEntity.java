package com.example.onlinesportshopee.entities;


import java.time.LocalDate;
import java.util.List;
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
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProductEntity> productEntity;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn //(name="paymentid")
	private PaymentEntity paymentEntity;
	
	public OrderEntity() {
		super();
	}

	public OrderEntity(Long id, Double amount, LocalDate billingDate, String paymentMethod, List<ProductEntity> productEntity,PaymentEntity paymentEntity) {
		super();
		this.id=id;
		this.amount = amount;
		this.billingDate = billingDate;
		this.paymentMethod = paymentMethod;
		this.productEntity=productEntity;
		this.paymentEntity=paymentEntity;
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

	public List<ProductEntity> getProductEntity(){ 
		return productEntity;
	  }
	  
	  public void setProductEntity(List<ProductEntity> productEntity) {
	  this.productEntity = productEntity; }
	 
	 

	public PaymentEntity getPaymentEntity() {
		return paymentEntity;
	}

	public void setPaymentEntity(PaymentEntity paymentEntity) {
		this.paymentEntity = paymentEntity;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderID=" + id+ ", amount=" + amount + ", billingDate=" + billingDate
				+ ", paymentMethod=" + paymentMethod + ", productEntity="
				+ productEntity + ", paymentEntity=" + paymentEntity + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

	
	