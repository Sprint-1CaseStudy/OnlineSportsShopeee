package com.example.onlinesportshopee.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.model.User;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	@Query(value = "SELECT * FROM users u WHERE u.username = ?1",nativeQuery = true)
	User findByUserName(String username);

}
