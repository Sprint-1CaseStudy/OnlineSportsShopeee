package com.example.onlinesportshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.example.onlinesportshopee.entities.ProductEntity;

import com.example.onlinesportshopee.model.Product;



public class ProductUtils {
	private ProductUtils() {
		
	}
	 public static List<Product> convertToProductDtoList(List<ProductEntity> list){
	        List<Product> productList = new ArrayList<>();
	        for(ProductEntity productEntity : list) 
	        	productList.add(convertToProduct(productEntity));
	        return productList;
	    }
	 
	 public static ProductEntity convertToProduct(Product product) {
	        ProductEntity productEntity = new ProductEntity();
	        productEntity.setId(product.getProductId());
	        productEntity.setProductName(product.getProductName());
	        productEntity.setCategory(product.getCategory());
	        productEntity.setDescription(product.getDescription());
	        productEntity.setBrand(product.getBrand());
	        productEntity.setColour(product.getColour());
	        productEntity.setSize(product.getSize());
	        productEntity.setMrp(product.getMrp());
	        productEntity.setPriceAfterDiscount(product.getPriceAfterDiscount());
	        productEntity.setInStock(product.isInStock());
	        productEntity.setExpectedDelivery(product.getExpectedDelivery());
	        return productEntity;
	     
	    }    
	 
	 public static Product convertToProduct(ProductEntity productEntity) {
		 Product product = new Product();
		 product.setProductId(productEntity.getId());
		 product.setProductName(productEntity.getProductName());
		 product.setCategory(productEntity.getCategory());
		 product.setDescription(productEntity.getDescription());
		 product.setBrand(productEntity.getBrand());
		 product.setColour(productEntity.getColour());
		 product.setSize(productEntity.getSize());
		 product.setMrp(productEntity.getMrp());
		 product.setPriceAfterDiscount(productEntity.getPriceAfterDiscount());
		 product.setInStock(productEntity.getInStock());
		 product.setExpectedDelivery(productEntity.getExpectedDelivery());
		 return product;
	 }

}
