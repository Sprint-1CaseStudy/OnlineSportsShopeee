package com.example.onlinesportshopee.util;

import java.util.ArrayList;

import java.util.List;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.model.Cart;


public class CartUtils {
	
	
	private CartUtils() {
        
    }
    
    public static List<Cart> convertToOrderDtoList(List<CartEntity> list){
        List<Cart> dtolist = new ArrayList<>();
        for(CartEntity cartEntity : list) 
            dtolist.add(convertToOrder(cartEntity));
        return dtolist;
    }
    
    public static CartEntity convertToOrder(Cart dto) {
    	CartEntity cart = new CartEntity();
    	
    	cart.setId(dto.getCartId());
        cart.setProductName(dto.getProductName());
        cart.setImageName(dto.getImageName());
        cart.setPrice(dto.getPrice());
        cart.setQuantity(dto.getQuantity());
        cart.setTotal(dto.getTotal());
        cart.setProductEntity(dto.getProductEntity());
        return cart;
    }        
    
    public static Cart convertToOrder(CartEntity cartEntity) {
    	Cart dto = new Cart();
    	dto.setCartId(cartEntity.getId());
        dto.setProductName(cartEntity.getProductName());
        dto.setImageName(cartEntity.getImageName());
        dto.setPrice(cartEntity.getPrice());
        dto.setQuantity(cartEntity.getQuantity());
        dto.setTotal(cartEntity.getTotal());
        dto.setProductEntity(cartEntity.getProductEntity());
        return dto;
    }

}
