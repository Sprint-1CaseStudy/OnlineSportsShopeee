package com.example.onlinesportsshopee.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.onlinesportshopee.controller.CustomerController;
import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.model.Customer;
import com.example.onlinesportshopee.services.ICustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.junit.jupiter.api.Test;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
class CustomerControllerTest {
		
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ICustomerService iCustomerService;
	
	@Test
	public void testaddCustomer() throws Exception
	{	
		String URI = "/onlinesportshopee/customers/addCustomer";
		
		CustomerEntity customer = new CustomerEntity();
		AddressEntity address = new AddressEntity();
		OrderEntity order = new OrderEntity();
		address.setId((long)10);
		address.setStreet("Blackstreet");
		address.setArea("Applepark");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(561234);
		
		order.setId((long)100);
		order.setAmount((double)25.36);
		order.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer.setId((long)1);
		customer.setName("Arjuna");
		customer.setEmail("Panadava3@gmail.com");
		customer.setContactNo("9512357468");
		customer.setDoB(LocalDate.parse("21/10/1997"));
		customer.setAddressEntity((List<AddressEntity>)address);
		customer.setOrderEntity((List<OrderEntity>) order);
		
		String jsonInput = this.convertToJson(customer);
		
		Mockito.when(iCustomerService.addCustomer(Mockito.any(CustomerEntity.class))).thenReturn(customer);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testgetCustomer() throws Exception
	{
		String URI= "/onlinesportshopee/customers/getCustomerDetails/{custId}";
		CustomerEntity customer = new CustomerEntity();
		AddressEntity address = new AddressEntity();
		OrderEntity order = new OrderEntity();
		address.setId((long)10);
		address.setStreet("Blackstreet");
		address.setArea("Applepark");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setPincode(561234);
		
		order.setId((long)100);
		order.setAmount((double)25.36);
		order.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer.setId((long)1);
		customer.setName("Arjuna");
		customer.setEmail("Panadava3@gmail.com");
		customer.setContactNo("9512357468");
		customer.setDoB(LocalDate.parse("21/10/1997"));
		customer.setAddressEntity((List<AddressEntity>)address);
		customer.setOrderEntity((List<OrderEntity>) order);
		
		String jsonInput = this.convertToJson(customer);
		Mockito.when(iCustomerService.getCustomer(Mockito.any())).thenReturn(customer);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	@Test
	public void testgetAllCustomer() throws Exception
	{
		String URI = "/onlinesportshopee/customers/Customers/{name}";
		CustomerEntity customer1 = new CustomerEntity();
		AddressEntity address1 = new AddressEntity();
		OrderEntity order1 = new OrderEntity();
		address1.setId((long)10);
		address1.setStreet("Blackstreet");
		address1.setArea("Applepark");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(561234);
		
		order1.setId((long)100);
		order1.setAmount((double)25.36);
		order1.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9512357468");
		customer1.setDoB(LocalDate.parse("21/10/1997"));
		customer1.setAddressEntity((List<AddressEntity>)address1);
		customer1.setOrderEntity((List<OrderEntity>)order1);
		
		CustomerEntity customer2 = new CustomerEntity();
		AddressEntity address2 = new AddressEntity();
		OrderEntity order2 = new OrderEntity();
		address2.setId((long)20);
		address2.setStreet("Whitestreet");
		address2.setArea("Orangepark");
		address2.setCity("Mysore");
		address2.setState("Karnataka");
		address2.setPincode(561235);
		
		order2.setId((long)200);
		order2.setAmount((double)52.63);
		order2.setBillingDate(LocalDate.parse("01/05/2020"));
		
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("19/12/1998"));
		customer2.setAddressEntity((List<AddressEntity>) address2);
		customer2.setOrderEntity((List<OrderEntity>) order2);
		
		List<CustomerEntity> customerlist = new ArrayList<>();
		customerlist.add(customer1);
		customerlist.add(customer2);
		
		String jsonInput = this.convertToJson(customerlist);
		
		Mockito.when(iCustomerService.getAllCustomers()).thenReturn(customerlist);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	@Test
	public void testremoveCustomer() throws Exception
	{
		String URI = "/onlinesportshopee/customers/removeCustomer/Customer/{custId}";
		CustomerEntity customer1 = new CustomerEntity();
		AddressEntity address1 = new AddressEntity();
		OrderEntity order1 = new OrderEntity();
		address1.setId((long)10);
		address1.setStreet("Blackstreet");
		address1.setArea("Applepark");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		address1.setPincode(561234);
		
		order1.setId((long)100);
		order1.setAmount((double)25.36);
		order1.setBillingDate(LocalDate.parse("01/04/2020"));
		
		customer1.setId((long)1);
		customer1.setName("Arjuna");
		customer1.setEmail("Panadava3@gmail.com");
		customer1.setContactNo("9851235467");
		customer1.setDoB(LocalDate.parse("21/10/1997"));
		customer1.setAddressEntity((List<AddressEntity>) address1);
		customer1.setOrderEntity((List<OrderEntity>) order1);
		
		Mockito.when(iCustomerService.getCustomer(Mockito.any())).thenReturn(customer1);
		Mockito.when(iCustomerService.removeCustomer(Mockito.any())).thenReturn(true);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testupdateCustomer() throws Exception
	{
		String URI = "/onlinesportshopee/customers/updateCustomer/{custId}";
		CustomerEntity customer2 = new CustomerEntity();
		AddressEntity address2 = new AddressEntity();
		OrderEntity order2 = new OrderEntity();
		address2.setId((long)20);
		address2.setStreet("Whitestreet");
		address2.setArea("Orangepark");
		address2.setCity("Mysore");
		address2.setState("Karnataka");
		address2.setPincode(561235);
		
		order2.setId((long)200);
		order2.setAmount((double)52.63);
		order2.setBillingDate(LocalDate.parse("01/05/2020"));
		
		customer2.setId((long)2);
		customer2.setName("Bheema");
		customer2.setEmail("Panadava2@gmail.com");
		customer2.setContactNo("9632588741");
		customer2.setDoB(LocalDate.parse("19/12/1998"));
		customer2.setAddressEntity((List<AddressEntity>) address2);
		customer2.setOrderEntity((List<OrderEntity>) order2);
		
		String jsonInput = this.convertToJson(customer2);
		
		Mockito.when(iCustomerService.updateCustomer(customer2.getId(),Mockito.any())).thenReturn(customer2);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	    String jsonOutput = mockHttpServletResponse.getContentAsString();
	    assertThat(jsonInput.substring(0,5)).isEqualTo(jsonOutput.substring(0,5));
	}
	
	private String convertToJson(Object customer) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(customer);
    }

}
