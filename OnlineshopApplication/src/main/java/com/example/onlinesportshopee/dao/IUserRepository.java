package com.example.onlinesportshopee.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.model.User;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	
	User findByUserName(String username);

}
