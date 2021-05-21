package com.example.onlinesportshopee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinesportshopee.entities.CardEntity;

@Repository
public interface ICardRepository extends JpaRepository<CardEntity,Long>{

}
