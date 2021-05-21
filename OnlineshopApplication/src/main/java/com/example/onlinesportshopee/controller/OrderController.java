package com.example.onlinesportshopee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.model.Order;
import com.example.onlinesportshopee.services.IOrderService;
import com.example.onlinesportshopee.services.OrderServiceImpl;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private IOrderService iOrderService;
	
	@PostMapping("/add-order")
	public  ResponseEntity<Object> addProduct(@RequestBody OrderEntity orderEntity)throws OrderNotFoundException,InvalidOrderIdException{
		LOGGER.info("add-order URL is opened");
		LOGGER.info("addOrderEntity() is initiated");
		System.out.println(orderEntity);
		Order orderDTO = null;
		ResponseEntity<Object> orderResponse = null;
		orderDTO = iOrderService.addOrder(orderEntity);
		orderResponse = new ResponseEntity<>(orderDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addOrder() has executed");
		return orderResponse;
	}
	@PutMapping("/update-order/{orderID}")
	public ResponseEntity<Object> updateOrder(@PathVariable long orderID, @RequestBody OrderEntity orderEntity)throws OrderNotFoundException,InvalidOrderIdException{
		LOGGER.info("update-order URL is opened");
		LOGGER.info("updateOrderEntity() is initiated");
		Order orderDTO = null;
		ResponseEntity<Object> orderResponse = null;
		orderDTO = iOrderService.updateOrder(orderID,orderEntity);
		orderResponse = new ResponseEntity<>(orderDTO, HttpStatus.ACCEPTED);
		LOGGER.info("updateOrder() has executed");//jh
		return orderResponse;
	}
	@DeleteMapping("/remove-order/{orderID}")
	public ResponseEntity<Object> deleteOrder(@PathVariable long orderID)throws InvalidOrderIdException{
		LOGGER.info("delete-order URL is opened");
		LOGGER.info("deleteOrderEntity() is initiated");
		Order orderDTO=null;
		ResponseEntity<Object> orderResponse = null;
		orderDTO = iOrderService.deleteOrder(orderID);
		orderResponse= new ResponseEntity<>(orderDTO, HttpStatus.ACCEPTED);
		LOGGER.info("deleteOrderEntity() has executed");
		return orderResponse;
	}
	@GetMapping("/get-order/{orderID}")
	public ResponseEntity<Object> getOrder(@PathVariable long orderID)throws InvalidOrderIdException{
	
		LOGGER.info("getById URL is opened");
		LOGGER.info("getById() is initiated");
		Order orderDTO = null;
		orderDTO = iOrderService.getOrderDetails(orderID);
		LOGGER.info("getOrderById() has executed");
		return new ResponseEntity<>(orderDTO, HttpStatus.ACCEPTED);
		
	}
	@GetMapping("/get-all-order/")
	public List<Order> getAllOrder(){
	
		LOGGER.info("getallorders URL is opened");
		LOGGER.info("getAllOrder() is initiated");
		LOGGER.info("getAllOrder() has executed");
		return iOrderService.getAllOrders();

	}
	
}
	
	
