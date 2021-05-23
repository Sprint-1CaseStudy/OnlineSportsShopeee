package com.example.onlinesportsshopee.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
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

import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.services.IOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderControllerTest.class)
class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IOrderService iOrderService;
	
	@Test
	void testAddOrder()throws Exception {
		 String URI = "/onlinesportshopee/add-order";
	        OrderEntity order = new OrderEntity();
	        order.setId((long)10);
	        order.setAmount(2331.33);
	        order.setBillingDate(LocalDate.parse("2021-08-09"));
	        order.setPaymentMethod("card");
	       // orderEntity.setCartEntity(null);	       
	        String jsonInput = this.convertToJson(order);

	       // Mockito.when(iOrderService.addOrder((long)10,(Mockito.any(Order.class))).thenReturn(order);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	}
	@Test
	void testGetOrderById() throws Exception
	{
		String URI="/get-order/{orderID}";
		OrderEntity order = new OrderEntity();
		order.setId((long)10);
	    order.setAmount(2331.33);
	    order.setBillingDate(LocalDate.parse("2021-08-09"));
	    order.setPaymentMethod("card");
		String jsonInput=this.convertToJson(order);
		
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 10).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	@Test
	void testGetAllOrders() throws Exception
	{
		String URI="/get-all-order/";
		OrderEntity order = new OrderEntity();
		order.setId((long)10);
	    order.setAmount(2331.33);
	    order.setBillingDate(LocalDate.parse("2021-08-09"));
	    order.setPaymentMethod("card");
	    
	    OrderEntity order1 = new OrderEntity();
	    order1.setId((long)11);
	    order1.setAmount(2331.33);
	    order1.setBillingDate(LocalDate.parse("2021-08-09"));
	    order1.setPaymentMethod("card");
	    
	    List<OrderEntity> orderList=new ArrayList<>();
	    orderList.add(order);
	    orderList.add(order1);
		String jsonInput=this.convertToJson(orderList);
		
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
	    //assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	 @Test
	 void testDeleteOrder() throws Exception{
	        String URI = "/remove-order/{orderID}";
	        OrderEntity order = new OrderEntity();
	        order.setId((long)10);
	        order.setAmount(2331.33);
	        order.setBillingDate(LocalDate.parse("2021-08-09"));
	        order.setPaymentMethod("card");

	        Mockito.when(iOrderService.deleteOrder(Mockito.any())).thenReturn(order);
	       Mockito.when(iOrderService.deleteOrder(Mockito.any())).thenReturn(true);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 10).accept(MediaType.
	        		APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	    }
	 @Test
	  void testUpdateOrder() throws Exception{

	        String URI = "/update-order/{orderID}";
	        OrderEntity order2 = new OrderEntity();
	        order2.setId((long)10);
	        order2.setAmount(3311.33);
	        order2.setBillingDate(LocalDate.parse("2021-07-09"));
	        order2.setPaymentMethod("net banking");
	        String jsonInput = this.convertToJson(order2);

	       // Mockito.when(iOrderService.updateOrder((long)10,(Mockito.any(),Mockito.anyString())).thenReturn(ticket2);
	        MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 10).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
			String jsonOutput=mockHttpServletResponse.getContentAsString();
			Assert.assertNotNull(jsonOutput);
	    }
	 
	 
	
	private String convertToJson(Object orderEntity)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orderEntity);
	}
}
