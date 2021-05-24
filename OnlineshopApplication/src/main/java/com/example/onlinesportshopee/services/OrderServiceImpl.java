package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.ICartRepository;
import com.example.onlinesportshopee.dao.IOrderRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.util.CartUtils;
import com.example.onlinesportshopee.util.OrderUtils;

@Service
public class OrderServiceImpl implements IOrderService {

	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired 
	private IOrderRepository iOrderRepository; 
	
	@Autowired 
	private ICartRepository iCartRepository;
	
	@Override
	public Order addOrder(Long cartID,Order order) throws OrderNotFoundException,InvalidOrderIdException{
		LOGGER.info("addOrder() service is initiated");
		CartEntity cartEntity = iCartRepository.findById(cartID).get();
		OrderEntity orderEntity = new OrderEntity(order.getAmount(),order.getBillingDate(),order.getPaymentMethod(),cartEntity);
		orderEntity=iOrderRepository.save(orderEntity);
		LOGGER.info("addOrder() service has executed");
		return OrderUtils.convertToOrder(orderEntity);
	}
	@Override
	public Order updateOrder(Long id,Order order)throws OrderNotFoundException,InvalidOrderIdException{
		LOGGER.info("updateOrder() service is initiated");
		OrderEntity ordEntity  = OrderUtils.convertToOrder(order);
		OrderEntity existOrd= iOrderRepository.findById(id).orElse(null);
		ordEntity = iOrderRepository.save(ordEntity);
		LOGGER.info("updateOrder() service has executed");
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public Order deleteOrder(Long id) throws InvalidOrderIdException{
		LOGGER.info("deleteOrder() service is initiated");
		OrderEntity ordEntity = iOrderRepository.findById(id).orElse(null);
	    iOrderRepository.delete(ordEntity);
		LOGGER.info("deleteOrder() service has executed");
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public Order getOrderDetails(Long id)throws InvalidOrderIdException {
		LOGGER.info("viewOrder() service is initiated");
		OrderEntity ordEntity = iOrderRepository.findById(id).orElse(null);
		if (ordEntity == null)
			throw new InvalidOrderIdException("orderIdIncorrect");
		LOGGER.info("viewOrder() service has executed");//gh
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public List<Order> getAllOrders(){
		List<OrderEntity> orderList = iOrderRepository.findAll();
		return OrderUtils.convertToOrderDtoList(orderList);
	}
	

}
