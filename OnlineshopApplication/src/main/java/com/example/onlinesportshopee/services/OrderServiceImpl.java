package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.IOrderRepository;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.util.OrderUtils;

@Service
public class OrderServiceImpl implements IOrderService {

	static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
	@Autowired 
	private IOrderRepository iOrderRepository; 
	
	@Override
	public Order addOrder(OrderEntity orderEntity) throws OrderNotFoundException,InvalidOrderIdException{
		LOGGER.info("addOrder() service is initiated");
		OrderEntity ordEntity;
		if(orderEntity==null)
			ordEntity=null;
		else {
			ordEntity=iOrderRepository.save(orderEntity);
			
		}
		LOGGER.info("addOrder() service has executed");
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public Order updateOrder(long id,OrderEntity orderEntity)throws OrderNotFoundException,InvalidOrderIdException{
		LOGGER.info("updateOrder() service is initiated");
		OrderEntity ordEntity;
		OrderEntity existOrd= iOrderRepository.findById(id).orElse(null);
		if (existOrd == null)
			throw new InvalidOrderIdException("orderIdNotAvailable");
		else {
			
			ordEntity = iOrderRepository.save(orderEntity);
		}
		LOGGER.info("updateOrder() service has executed");
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public Order deleteOrder(long id) throws InvalidOrderIdException{
		LOGGER.info("deleteOrder() service is initiated");
		OrderEntity ordEntity = iOrderRepository.findById(id).orElse(null);
		if (ordEntity == null)
			throw new InvalidOrderIdException("orderNotFound");
		else
			iOrderRepository.delete(ordEntity);
		LOGGER.info("deleteOrder() service has executed");
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public Order getOrderDetails(long id)throws InvalidOrderIdException {
		LOGGER.info("viewOrder() service is initiated");
		OrderEntity ordEntity = iOrderRepository.findById(id).orElse(null);
		if (ordEntity == null)
			throw new InvalidOrderIdException("orderNotFound");
		LOGGER.info("viewOrder() service has executed");//gh
		return OrderUtils.convertToOrder(ordEntity);
	}
	@Override
	public List<Order> getAllOrders(){
		List<OrderEntity> orderList = iOrderRepository.findAll();
		return OrderUtils.convertToOrderDtoList(orderList);
	}
	

}
