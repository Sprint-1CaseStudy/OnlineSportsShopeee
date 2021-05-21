package com.example.onlinesportshopee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.onlinesportshopee.entities.OrderEntity;


@Repository
public interface IOrderRepository extends JpaRepository<OrderEntity,Long>{

}
