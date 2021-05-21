package com.example.onlinesportshopee.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.*;

import com.example.onlinesportshopee.entities.CartEntity;

@Repository
public interface ICartRepository extends JpaRepository<CartEntity,Long>{

}
