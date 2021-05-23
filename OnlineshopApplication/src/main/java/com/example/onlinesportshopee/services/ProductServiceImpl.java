package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.ProductNotFoundException;
import com.example.onlinesportshopee.model.Product;
import com.example.onlinesportshopee.util.ProductUtils;

@Service
public class ProductServiceImpl implements IProductService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	
	@Autowired 
	private IProductRepository iProductRepository;
	
	@Override
	public Product addProduct(Product product) {
		LOGGER.info("addProduct() serivice is initiated");
     ProductEntity productEntity = ProductUtils.convertToProduct(product);
     /*if(product == null)
    	 productEntity = null;
     else {*/
    	 productEntity = iProductRepository.save(productEntity);

     LOGGER.info("addProduct() service has executed");
     return ProductUtils.convertToProduct(productEntity);
     
	}

	@Override
	public Product removeProduct(Long productId) {
		LOGGER.info("removeProduct() serivice is initiated");
		ProductEntity delproduct = iProductRepository.findById(productId).get();
		iProductRepository.delete(delproduct);
		LOGGER.info("removeProduct() service has executed");
		return ProductUtils.convertToProduct(delproduct);
	}

	
	@Override
	public Product updateProduct(Long productId, Product product) {
		LOGGER.info("updateProduct() serivice is initiated");
		ProductEntity productEntity = ProductUtils.convertToProduct(product);
		ProductEntity updateProduct = iProductRepository.findById(productId).get();
		productEntity = iProductRepository.save(productEntity);
		LOGGER.info("updateProduct() service has executed");
		return ProductUtils.convertToProduct(productEntity);
	}

	@Override
	public Product getProduct(Long productId) {
		LOGGER.info("getProduct() serivice is initiated");
		ProductEntity getProduct = iProductRepository.findById(productId).get();
		LOGGER.info("getProduct() service has executed");
		return ProductUtils.convertToProduct(getProduct);
	}

	@Override
	public List<Product> getAllProduct() {
		LOGGER.info("getAllProduct() serivice is initiated");
		List<ProductEntity> getAllProduct = iProductRepository.findAll();
		LOGGER.info("getAllProduct() service has executed");
		return ProductUtils.convertToProductDtoList(getAllProduct);
	}
	
	@Override
	public List<Product> getProductsByName(String name) throws ProductNotFoundException
	{
		LOGGER.info("getProductByName() serivice is initiated");
		List<ProductEntity> getProductName = iProductRepository.findByName(name);
		if (getProductName == null)
		{
			String namenotfound = "No products found by the name "+name;
			throw new ProductNotFoundException(namenotfound);
		}
		LOGGER.info("getProductByName() service has executed");
		return ProductUtils.convertToProductDtoList(getProductName);
	}
	
	
	@Override
	public List<Product> getProductsBySize(String size) throws ProductNotFoundException
	{
		LOGGER.info("getProductBySize() serivice is initiated");
		List<ProductEntity> productSize = iProductRepository.findBySize(size);
		if (productSize == null)
		{
			String sizenotfound = "No products found by the size "+size;
			throw new ProductNotFoundException(sizenotfound);
		}
		LOGGER.info("getProductBySize() service has executed");
		return ProductUtils.convertToProductDtoList(productSize);
	}
	
	@Override
	public List<Product> getProductsByPrice(Double price) throws ProductNotFoundException
	{
		LOGGER.info("getProductByPrice() serivice is initiated");
		List<ProductEntity> productPrice = iProductRepository.findByPrice(price);
		if (productPrice == null)
		{
			String pricenotfound = "No products found by the price "+price;
			throw new ProductNotFoundException(pricenotfound);
		}
		LOGGER.info("getProductByPrice() service has executed");
		return ProductUtils.convertToProductDtoList(productPrice);
		
	}
	
	@Override
	public List<Product> getProductsByColor(String color) throws ProductNotFoundException
	{
		LOGGER.info("getProductByColor() serivice is initiated");
		List<ProductEntity> productColor = iProductRepository.findByColor(color);
		if (productColor == null)
		{
			String colornotfound = "No products found by the color "+color;
			throw new ProductNotFoundException(colornotfound);
		}
		LOGGER.info("getProductByColor() service has executed");
		return ProductUtils.convertToProductDtoList(productColor);
	}

	
}
