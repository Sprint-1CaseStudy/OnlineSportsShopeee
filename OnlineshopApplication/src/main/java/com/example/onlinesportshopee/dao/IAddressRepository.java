package com.example.onlinesportshopee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinesportshopee.entities.AddressEntity;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

}
//