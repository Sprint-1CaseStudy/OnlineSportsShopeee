package com.example.OnlineSportsShopee;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.InvalidProductInputException;
import com.example.onlinesportshopee.exception.ProductNotFoundException;
import com.example.onlinesportshopee.services.IProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {
	
	@MockBean
	private IProductRepository productRepository;

	@Autowired
	private IProductService productService;
	
    
	
	@BeforeAll
	public static void beforeAll() {
		
	}
	
	@Test
	public void testAddProduct() {
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		Mockito.when(productRepository.save(productEnt)).thenReturn(productEnt);
		
		assertThat(productService.addProduct(productEnt)).isEqualTo(productEnt);
		
	}
	
	@Test
	public void testDeleteProduct() throws ProductNotFoundException, InvalidProductInputException {
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
	
		Mockito.when(productRepository.save(productEnt)).thenReturn(productEnt);
		Mockito.when(productRepository.findById((long)101).get()).thenReturn(productEnt);
		productRepository.deleteById(productEnt.getId());
		Mockito.when(productRepository.findById((long)101).get()).thenReturn(productEnt);
		Assert.assertNotEquals(productEnt, new ProductEntity());
		Assert.assertEquals(productService.removeProduct(101), false);
		
	}
	
	@Test
	public void testUpdateProduct() throws ProductNotFoundException, InvalidProductInputException {
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		productRepository.save(productEnt);
		Mockito.when(productRepository.findById((long)101).get()).thenReturn(productEnt);
		productEnt.setSize("9UK");
		productEnt.setColour("Black");
		Mockito.when(productRepository.save(productEnt)).thenReturn(productEnt);
		System.out.println(productEnt.getSize());
		assertThat(productService.updateProduct(101, productEnt)).isEqualTo(productEnt);
		
	}
	
	@Test
	public void testGetProduct() throws ProductNotFoundException, InvalidProductInputException{
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		ProductEntity pe = productRepository.findById((long)101).get();
		Mockito.when(pe).thenReturn(productEnt);
		assertThat(productService.getProduct(101)).isEqualTo(productEnt);
		
	}
	
	@Test
	public void testGetAllProducts() throws ProductNotFoundException, InvalidProductInputException{
		
		ProductEntity productEnt1 = new ProductEntity();
		productEnt1.setId((long)101);
		productEnt1.setProductName("Shoes");
		productEnt1.setCategory("Sports Shoes");
		productEnt1.setDescription("Light weight, made with high quality material");
		productEnt1.setBrand("Adidas");
		productEnt1.setColour("White");
		productEnt1.setSize("10UK");
		productEnt1.setMrp(7000.00);
		productEnt1.setPriceAfterDiscount(5000.00);
		productEnt1.setInStock(true);
		productEnt1.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt1.setOrderEntity(null);
		productEnt1.setCartEntity(null);
	
		ProductEntity productEnt2 = new ProductEntity();
		productEnt2.setId((long)102);
		productEnt2.setProductName("Band");
		productEnt2.setCategory("Fitness Band");
		productEnt2.setDescription("heart rate detection, steps tracking ");
		productEnt2.setBrand("OnePlus");
		productEnt2.setColour("Black");
		productEnt2.setSize("350mm");
		productEnt2.setMrp(3000.00);
		productEnt2.setPriceAfterDiscount(2500.00);
		productEnt2.setInStock(true);
		productEnt2.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt2.setOrderEntity(null);
		productEnt2.setCartEntity(null);
		
		List<ProductEntity> productList = new ArrayList<>();
		productList.add(productEnt1);
		productList.add(productEnt2);
		
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		assertThat(productService.getAllProduct()).isEqualTo(productList);
		
	}
	
	@Test
	public void testGetProductByName() throws ProductNotFoundException, InvalidProductInputException{
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		Mockito.when(productRepository.findByName("Shoes")).thenReturn((List<ProductEntity>) productEnt);
		assertThat(productService.getProductsByName("Shoes")).isEqualTo(productEnt);
		
	}
	
	@Test
	public void testGetProductBySize() throws ProductNotFoundException, InvalidProductInputException{
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		Mockito.when(productRepository.findBySize("10UK")).thenReturn((List<ProductEntity>) productEnt);
		assertThat(productService.getProductsBySize("10UK")).isEqualTo(productEnt);
	}
	
	@Test
	public void testGetProductByPrice() throws ProductNotFoundException, InvalidProductInputException{
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		Mockito.when(productRepository.findByPrice(7000.00)).thenReturn((List<ProductEntity>) productEnt);
		assertThat(productService.getProductsByPrice(7000.00)).isEqualTo(productEnt);
	}
	
	@Test
	public void testGetProductByColour() throws ProductNotFoundException, InvalidProductInputException{
		
		ProductEntity productEnt = new ProductEntity();
		productEnt.setId((long)101);
		productEnt.setProductName("Shoes");
		productEnt.setCategory("Sports Shoes");
		productEnt.setDescription("Light weight, made with high quality material");
		productEnt.setBrand("Adidas");
		productEnt.setColour("White");
		productEnt.setSize("10UK");
		productEnt.setMrp(7000.00);
		productEnt.setPriceAfterDiscount(5000.00);
		productEnt.setInStock(true);
		productEnt.setExpectedDelivery(LocalDate.parse("29-05-2021"));
		productEnt.setOrderEntity(null);
		productEnt.setCartEntity(null);
		
		Mockito.when(productRepository.findByColor("White")).thenReturn((List<ProductEntity>) productEnt);
		assertThat(productService.getProductsByColor("White")).isEqualTo(productEnt);
	}
	
	@AfterAll
	public static void end() {
		
	}

}