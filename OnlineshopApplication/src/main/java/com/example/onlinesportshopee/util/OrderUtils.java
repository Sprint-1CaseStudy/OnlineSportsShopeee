package com.example.onlinesportshopee.util;

import java.util.ArrayList;
import java.util.List;

import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.model.Order;

 public class OrderUtils {
private OrderUtils() {
        
    }
    
    public static List<Order> convertToOrderDtoList(List<OrderEntity> list){
        List<Order> dtolist = new ArrayList<>();
        for(OrderEntity orderEntity : list) 
            dtolist.add(convertToOrder(orderEntity));
        return dtolist;
    }
    
    public static OrderEntity convertToOrder(Order dto) {
        OrderEntity order = new OrderEntity();
        order.setId(dto.getOrderID());
        order.setAmount(dto.getAmount());
        order.setBillingDate(dto.getBillingDate());
        order.setPaymentMethod(dto.getPaymentMethod());
        order.setCartEntity(dto.getCartEntity());
        return order;
    }        
    
    public static Order convertToOrder(OrderEntity orderEntity) {
        Order dto = new Order();
        dto.setOrderID(orderEntity.getId());
        dto.setAmount(orderEntity.getAmount());
        dto.setBillingDate(orderEntity.getBillingDate());
        dto.setPaymentMethod(orderEntity.getPaymentMethod());
        dto.setCartEntity(orderEntity.getCartEntity());
        return dto;
    }
}
