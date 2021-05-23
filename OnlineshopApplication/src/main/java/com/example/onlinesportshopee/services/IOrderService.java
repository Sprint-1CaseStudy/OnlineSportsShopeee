package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.exception.InvalidOrderIdException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.model.Order;
import java.util.List;

public interface IOrderService {
public Order addOrder(Order order) throws OrderNotFoundException,InvalidOrderIdException;
public Order updateOrder(Long id,Order order)throws OrderNotFoundException,InvalidOrderIdException;
public Order deleteOrder(Long id) throws InvalidOrderIdException;
public Order getOrderDetails(Long id)throws InvalidOrderIdException;
public List<Order> getAllOrders();

}
