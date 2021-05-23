package com.example.onlinesportsshopee.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.ProductEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootConfiguration
class ProductDaoTest {
	
	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Test
	public void testAddProduct() throws Exception{
		
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			ProductEntity saveInDb = testEntityManager.persist(productEnt);
			ProductEntity getFromInDb = productRepository.findById(saveInDb.getId()).get();
			assertThat(getFromInDb).isEqualTo(saveInDb);
		
	}
	
	@Test
	public void testGetProduct() throws Exception {
		
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));

			ProductEntity saveInDb = testEntityManager.persist(productEnt);
			ProductEntity getFromInDb = productRepository.findById(saveInDb.getId()).get();
			assertThat(getFromInDb).isEqualTo(saveInDb);
			
		
	}
	
	@Test
	public void testGetAllProducts() throws Exception {
		
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
			productEnt1.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
		
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
			productEnt2.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			testEntityManager.persist(productEnt1);
			testEntityManager.persist(productEnt2);
			
			List<ProductEntity> productList = (List<ProductEntity>) productRepository.findAll();
			Assert.assertEquals(2, productList.size());
		
	}
	
	@Test
	public void testDeleteProduct() throws Exception {
		
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
		productEnt1.setExpectedDelivery(LocalDate.parse("2021-05-29"));
		
	
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
		productEnt2.setExpectedDelivery(LocalDate.parse("2021-05-29"));
		
		ProductEntity productEn = testEntityManager.persist(productEnt1);
		testEntityManager.persist(productEnt2);
		
		testEntityManager.remove(productEn);
		
		List<ProductEntity> productList = (List<ProductEntity>) productRepository.findAll();
		Assert.assertEquals(productList.size(), 1);
	}
	
	@Test
	public void testUpdateProduct() throws Exception {
		
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			testEntityManager.persist(productEnt);
			ProductEntity getFromDb = productRepository.findById((long)101).get();
			getFromDb.setColour("Red");
			testEntityManager.persist(getFromDb);
			Assert.assertEquals(getFromDb.getColour(), "Red");
		
	}
	
	@Test
	public void testGetProductByName() throws Exception {
		  
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			ProductEntity saveInDb = testEntityManager.persist(productEnt);
			ProductEntity getInDb = (ProductEntity) productRepository.findByName(saveInDb.getProductName());
			Assert.assertEquals(saveInDb.getProductName(), getInDb.getProductName());
		
	}

	@Test
	public void testGetProductBySize() throws Exception {
		  
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			ProductEntity saveInDb = testEntityManager.persist(productEnt);
			ProductEntity getInDb = (ProductEntity) productRepository.findBySize(saveInDb.getSize());
			Assert.assertEquals(saveInDb.getSize(), getInDb.getSize());
		
	}
	
	@Test
	public void testGetProductByColor() throws Exception {
		  
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			ProductEntity saveInDb = testEntityManager.persist(productEnt);
			ProductEntity getInDb = (ProductEntity) productRepository.findByColor(saveInDb.getColour());
			Assert.assertEquals(saveInDb.getColour(), getInDb.getColour());
		
	}
	
	@Test
	public void testGetProductByPrice() throws Exception {
		  
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
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
			
			ProductEntity saveInDb = testEntityManager.persist(productEnt);
			ProductEntity getInDb = (ProductEntity) productRepository.findByPrice(saveInDb.getMrp());
			Assert.assertEquals(saveInDb.getMrp(), getInDb.getMrp());
		
	}


}
