package com.example.onlinesportsshopee.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
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
	        OrderEntity orderEntity = new OrderEntity();
	        orderEntity.setId((long)10);
	        orderEntity.setAmount(2331.33);
	        orderEntity.setBillingDate(LocalDate.parse("2021-08-09"));
	        orderEntity.setPaymentMethod("card");
	        orderEntity.setCustomerEntity(new CustomerEntity());
	        orderEntity.setProductEntity(null);
	        orderEntity.setPaymentEntity(new PaymentEntity());
	       
	        String jsonInput = this.convertToJson(orderEntity);

	        Mockito.when(iOrderService.addOrder(Mockito.any(OrderEntity.class))).thenReturn(orderEntity);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	 
	
	private String convertToJson(Object orderEntity)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orderEntity);
	}
}
