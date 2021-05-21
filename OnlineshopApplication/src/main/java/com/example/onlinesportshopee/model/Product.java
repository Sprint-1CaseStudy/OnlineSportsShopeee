package com.example.onlinesportshopee.model;



import java.time.LocalDate;
import java.util.List;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.OrderEntity;



public class Product {
	
	
	private Long productId;

	private String productName;

	private String category;

	private String description;
	
	private String brand;
	
	private String colour;
	
	private String size;
	
	private Double mrp;
	
	private Double priceAfterDiscount;
	
	private Boolean inStock;

	private LocalDate expectedDelivery;
	
	private OrderEntity orderEntity;
	private List<CartEntity> cartEntity;
	
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public Double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(Double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public Boolean isInStock() {
		return inStock;
	}
	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	public LocalDate getExpectedDelivery() {
		return expectedDelivery;
	}
	public void setExpectedDelivery(LocalDate expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}
	
	public OrderEntity getOrderEntity() {
		return orderEntity;
	}
	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}
	public List<CartEntity> getCartEntity() {
		return cartEntity;
	}
	public void setCartEntity(List<CartEntity> cartEntity) {
		this.cartEntity = cartEntity;
	}
	public Product(Long productId, String productName, String category, String description, String brand, String colour,
			String size, Double mrp, Double priceAfterDiscount, Boolean inStock, LocalDate expectedDelivery,
			OrderEntity orderEntity,List<CartEntity> cartEntity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.description = description;
		this.brand = brand;
		this.colour = colour;
		this.size = size;
		this.mrp = mrp;
		this.priceAfterDiscount = priceAfterDiscount;
		this.inStock = inStock;
		this.expectedDelivery = expectedDelivery;
		this.orderEntity = orderEntity;
		this.cartEntity=cartEntity;
	}
	
	public Product() {
		super();
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", description=" + description + ", brand=" + brand + ", colour=" + colour + ", size=" + size
				+ ", mrp=" + mrp + ", priceAfterDiscount=" + priceAfterDiscount + ", inStock=" + inStock
				+ ", expectedDelivery=" + expectedDelivery + "]";
	}	
	
}
