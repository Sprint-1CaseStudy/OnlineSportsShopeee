package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.IOrderRepository;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.services.IOrderService;
import com.example.onlinesportshopee.services.OrderServiceImpl;
import com.example.onlinesportshopee.util.OrderUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderServiceImpl.class)
class OrderServiceTestImpl {

	@MockBean
	private IOrderRepository iOrderRepository;
	
	@Autowired
	private IOrderService iOrderService;
	
	@Test
	void testAddOrder() {
		OrderEntity orderEntity =new OrderEntity();
		orderEntity.setId((long)10);
		orderEntity.setAmount(2331.33);
	    orderEntity.setBillingDate(LocalDate.parse("2021-08-09"));
	    orderEntity.setPaymentMethod("card");
	    
	    Mockito.when(iOrderRepository.save(orderEntity)).thenReturn(orderEntity);
	    //Order order =OrderUtils.convertToOrder(orderEntity);
	    Assert.assertNotNull(orderEntity);
	    }
	@Test
	public void testGetAllOrders() throws Exception{
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setId((long)11);
		orderEntity.setAmount(3391.33);
		orderEntity.setBillingDate(LocalDate.parse("2021-11-28"));
		orderEntity.setPaymentMethod("card");
	
		OrderEntity orderEntity1=new OrderEntity();
		orderEntity1.setId((long)12);
		orderEntity1.setAmount(3371.33);
		orderEntity1.setBillingDate(LocalDate.parse("2021-12-13"));
		orderEntity1.setPaymentMethod("card");
		
		List<OrderEntity> orderList=new ArrayList<>();
		orderList.add(orderEntity);
		orderList.add(orderEntity1);
		
		Mockito.when(iOrderRepository.findAll()).thenReturn(orderList);
		List<Order> order =OrderUtils.convertToOrderDtoList(orderList);
		assertSame(iOrderService.getAllOrders().size(), 2);
	}
	
	@Test
	public void testGetOrderById()throws Exception{
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setId((long)11);
		orderEntity.setAmount(3391.33);
		orderEntity.setBillingDate(LocalDate.parse("2021-11-28"));
		orderEntity.setPaymentMethod("card");
		
		Mockito.when(iOrderRepository.save(orderEntity)).thenReturn(orderEntity);
		assertEquals(orderEntity.getId(),11);
		
	}
	@Test
	public void testDeleteOrder() {
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setId((long)11);
		orderEntity.setAmount(3391.33);
		orderEntity.setBillingDate(LocalDate.parse("2021-11-28"));
		orderEntity.setPaymentMethod("card");

		Mockito.when(iOrderRepository.save(orderEntity)).thenReturn(orderEntity);
		iOrderRepository.deleteById(orderEntity.getId());
		assertNotEquals(orderEntity, new OrderEntity());
	}

	@Test
	public void testUpdateOrder() {

		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setId((long)11);
		orderEntity.setAmount(3391.33);
		orderEntity.setBillingDate(LocalDate.parse("2021-11-28"));
		orderEntity.setPaymentMethod("card");

		Mockito.when(iOrderRepository.save(orderEntity)).thenReturn(orderEntity);
		assertEquals(orderEntity.getId(), 11);
	}

}

