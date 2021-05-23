package com.example.onlinesportshopee.model;

import java.util.List;

import com.example.onlinesportshopee.entities.ProductEntity;

public class Cart {
	
	private Long cartId;
	private String productName;
	private Integer quantity;
	private Double price;
	private Double total;
	
	public Cart() {
		super();
	}

	public Cart(Long cartId, String productName, Integer quantity, Double price, Double total) {
		super();
		this.cartId = cartId;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
	}

	

	

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	

	
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", productName=" + productName + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + "]";
	}


	
}
