package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.model.Order;
import java.util.List;

public interface IOrderService {
public Order addOrder(OrderEntity orderEntity) throws OrderNotFoundException,InvalidOrderIdException;
public Order updateOrder(long id,OrderEntity orderEntity)throws OrderNotFoundException,InvalidOrderIdException;
public Order deleteOrder(long id) throws InvalidOrderIdException;
public Order getOrderDetails(long id)throws InvalidOrderIdException;
public List<Order> getAllOrders();

}
