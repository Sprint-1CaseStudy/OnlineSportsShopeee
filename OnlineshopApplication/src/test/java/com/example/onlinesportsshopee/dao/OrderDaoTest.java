package com.example.onlinesportsshopee.dao;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.IOrderRepository;
import com.example.onlinesportshopee.entities.OrderEntity;

@RunWith(SpringRunner.class)
@DataJpaTest
class OrderDaoTest {
	
	@Autowired 
	private IOrderRepository iOrderRepository;
	
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	void testAddOrder()throws Exception {
		OrderEntity orderEntity=getOrder();
		OrderEntity saveInDb=testEntityManager.persist(orderEntity);
		OrderEntity getFromDb=iOrderRepository.findById(saveInDb.getId()).get();
		assertThat(getFromDb).isEqualTo(saveInDb);
	}
	@Test
	public void testGetOrderById()throws Exception{
		OrderEntity orderEntity =new OrderEntity();
		orderEntity.setId((long)11);
		orderEntity.setAmount(3331.33);
		orderEntity.setBillingDate(LocalDate.parse("2021-07-25"));
		orderEntity.setPaymentMethod("card");
		
		OrderEntity saveInDb = testEntityManager.persist(orderEntity);
		OrderEntity getFromDb = iOrderRepository.findById(orderEntity.getId()).get();
		assertThat(getFromDb).isEqualTo(saveInDb);
	}
	@Test
	public void testGetAllOrders()throws Exception{
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
		
		testEntityManager.persist(orderEntity);
		testEntityManager.persist(orderEntity1);
		List<OrderEntity> orderList=(List<OrderEntity>)iOrderRepository.findAll();
		Assert.assertEquals(2, orderList.size());
		
	}
	@Test
	public void testDeletOrderById()throws Exception{
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
		
		OrderEntity orderEntity2=testEntityManager.persist(orderEntity);
		testEntityManager.persist(orderEntity1);
		
		testEntityManager.remove(orderEntity2);
		
		List<OrderEntity> orderList=(List<OrderEntity>)iOrderRepository.findAll();
		Assert.assertEquals(orderList.size(),1);
		
	}
	@Test
	public void testUpdateOrder() {
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setId((long)11);
		orderEntity.setAmount(3391.33);
		orderEntity.setBillingDate(LocalDate.parse("2021-11-28"));
		orderEntity.setPaymentMethod("card");
		
		OrderEntity saveInDb = testEntityManager.persist(orderEntity);

		OrderEntity getFromDb = iOrderRepository.findById(orderEntity.getId()).get();
		assertThat(getFromDb.getId()).isEqualTo(saveInDb);
	}
	
	private OrderEntity getOrder() {
		 OrderEntity order = new OrderEntity();
		 order.setId((long)10);
	     order.setAmount(2331.33);
	     order.setBillingDate(LocalDate.parse("2021-08-09"));
	     order.setPaymentMethod("card");
	     return order;
	    }

}
