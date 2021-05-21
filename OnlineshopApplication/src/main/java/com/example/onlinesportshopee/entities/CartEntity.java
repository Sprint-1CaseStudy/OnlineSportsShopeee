package com.example.onlinesportshopee.entities;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Cart")
public class CartEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ImageName")
	private String imageName;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "Quantity")
	private Integer quantity;
	@Column(name = "Price")
	private Double price;
	@Column(name="ToatlBill")
	private Double total;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn//(name="product-cart")
	private List<ProductEntity> productEntity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	public List<ProductEntity> getProductEntity() {
		return productEntity;
	}
	public void setProductEntity(List<ProductEntity> productEntity) {
		this.productEntity = productEntity;
	}
	@Override
	public String toString() {
		return "CartEntity [id=" + id + ", imageName=" + imageName + ", productName=" + productName + ", quantity="
				+ quantity + ", price=" + price + ", total=" + total + ", productEntity=" + productEntity + "]";
	}
	public CartEntity(Long id, String imageName, String productName, Integer quantity, Double price, Double total,
			List<ProductEntity> productEntity) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.productEntity = productEntity;
	}
	
	public CartEntity() {}
	
}

	
	