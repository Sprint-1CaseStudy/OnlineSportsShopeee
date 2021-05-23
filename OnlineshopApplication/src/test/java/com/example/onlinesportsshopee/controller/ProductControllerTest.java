package com.example.onlinesportsshopee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.onlinesportshopee.controller.ProductController;
import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.model.Product;
import com.example.onlinesportshopee.services.IProductService;
import com.example.onlinesportshopee.util.ProductUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {

	 @Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
	 private IProductService productService;
	 
	 @Autowired
	 private IProductRepository productRepository;
	 
	 @Test
	 public void testAddOrder() throws Exception {
		 
		 String URI = "/onlinesportshopee/products/addproduct";
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
			
			String jsonInput = this.converttoJson(productEnt);
			Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.addProduct(Mockito.any(Product.class))).thenReturn(product);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		 
	 }
	 
	 @Test
	 public void getProductById() throws Exception{
		 
		 String URI = "/onlinesportshopee/products/getproduct/{productId}";
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
			
			String jsonInput = this.converttoJson(productEnt);
			
			Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.getProduct(Mockito.any())).thenReturn(product);
			 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		        String jsonOutput = mockHttpServletResponse.getContentAsString();

		        assertThat(jsonInput).isEqualTo(jsonOutput);
		 
	 }

	@Test
	 public void testGetAllProducts() throws Exception{
		 
		 String URI = "/onlinesportshopee/products/getallproduct";
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
			

			List<ProductEntity> productList = new ArrayList<>();
			productList.add(productEnt1);
			productList.add(productEnt2);
			
			String jsonInput = this.converttoJson(productList);
		
			Product product = (Product) ProductUtils.convertToProductDtoList(productList);
			Mockito.when(productService.getAllProduct()).thenReturn((List<Product>) product);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		    String jsonOutput = mockHttpServletResponse.getContentAsString();

		    assertThat(jsonInput).isEqualTo(jsonOutput);
		 
	 }
	
	@Test
	public void testDeleteProduct() throws Exception {
		
		String URI = "/onlinesportshopee/products/removeproduct/product/{productId}";
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
			
			Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.getProduct(Mockito.any())).thenReturn(product);
			Mockito.when(productService.removeProduct(Mockito.any())).thenReturn(null);
			 MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
		        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

		        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		        
	}
	
	@Test
	public void testUpdateProduct(IntPredicate jsonInput) throws Exception {
		
		String URI = "/onlinesportshopee/products/updateproduct/{productId}";
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
			
			productRepository.save(productEnt);
			
			Mockito.when(productRepository.findById((long)101).get()).thenReturn(productEnt);
			productEnt.setBrand("Nike");
			productEnt.setColour("Black");
			Mockito.when(productRepository.save(productEnt)).thenReturn(productEnt);			
			Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.updateProduct((long)101, product)).thenReturn(product);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 101).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();

	        assertThat(jsonInput).isEqualTo(jsonOutput);
			
			
	}
	
	@Test
	public void testGetProductByName() throws Exception {
		
		String URI = "/onlinesportshopee/products/byname/{name}";
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
			
			String jsonInput = this.converttoJson(productEnt);
			//Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.getProductsByName(Mockito.anyString())).thenReturn((List<Product>) productEnt);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, "Shoes").accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	      //  String jsonOutput = mockHttpServletResponse.getContentAsString();
	   //System.out.println(jsonInput);
	   //System.out.println(jsonOutput);
	   
	       // MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
	}
	@Test
	public void testGetProductBySize() throws Exception {
		
		String URI = "/onlinesportshopee/products/byname/{name}";
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
			
			String jsonInput = this.converttoJson(productEnt);
			//Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.getProductsBySize(Mockito.anyString())).thenReturn((List<Product>) productEnt);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, "10UK").accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	      //  String jsonOutput = mockHttpServletResponse.getContentAsString();
	   //System.out.println(jsonInput);
	   //System.out.println(jsonOutput);
	   
	       // MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
	}
	
	@Test
	public void testGetProductByPrice() throws Exception {
		
		String URI = "/onlinesportshopee/products/byname/{name}";
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
			
			String jsonInput = this.converttoJson(productEnt);
			//Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.getProductsByPrice(Mockito.anyDouble())).thenReturn((List<Product>) productEnt);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 7000.00).accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	      //  String jsonOutput = mockHttpServletResponse.getContentAsString();
	   //System.out.println(jsonInput);
	   //System.out.println(jsonOutput);
	   
	       // MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetProductByColor() throws Exception {
		
		String URI = "/onlinesportshopee/products/byname/{name}";
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
			
			String jsonInput = this.converttoJson(productEnt);
			//Product product = ProductUtils.convertToProduct(productEnt);
			Mockito.when(productService.getProductsByColor(Mockito.anyString())).thenReturn((List<Product>) productEnt);
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, "White").accept(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	      //  String jsonOutput = mockHttpServletResponse.getContentAsString();
	   //System.out.println(jsonInput);
	   //System.out.println(jsonOutput);
	   
	       // MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
		
	}
	
	 
	private String converttoJson(Object product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
    }
	
	 
}
