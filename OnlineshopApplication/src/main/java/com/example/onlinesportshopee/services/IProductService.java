package com.example.onlinesportshopee.services;

import java.util.List;




import com.example.onlinesportshopee.exception.ProductNotFoundException;
import com.example.onlinesportshopee.model.Product;


public interface IProductService {

	public Product addProduct(Product product);
	public Product removeProduct(Long productId);
	public Product updateProduct(Long productId, Product product);
	public Product getProduct(Long productId);
	public List<Product> getAllProduct();
	
	List<Product> getProductsByName(String name) throws ProductNotFoundException;
	List<Product> getProductsBySize(String size) throws ProductNotFoundException;
	List<Product> getProductsByPrice(Double price) throws ProductNotFoundException;
	List<Product> getProductsByColor(String color) throws ProductNotFoundException;	
	
}
