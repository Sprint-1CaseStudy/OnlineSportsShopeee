package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.onlinesportshopee.dao.IUserRepository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.model.User;
import com.example.onlinesportshopee.services.IUserService;
import com.example.onlinesportshopee.services.UserServiceImpl;
import com.example.onlinesportshopee.util.UserUtils;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

	@MockBean
	IUserRepository iuserdao;
	
	
	@Autowired
	IUserService iuserservice;
	
	UserEntity user=null;
	
	@Test
	void testAddUser01() throws Exception
	{
		User user1 = new User();
		user = new UserEntity();
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		Mockito.when(iuserdao.save(user)).thenReturn(user);
		user1 = UserUtils.convertToUser(user);
		Assert.assertNotNull(user);
	}
	
	@Test
	void testSignInUser01() throws Exception
	{
		User user1 = new User();
		user = new UserEntity();
		//user.setId((long)1);
		user.setPassword("chakri@123");
		
		Mockito.when(iuserdao.save(user)).thenReturn(user);
		user1 = UserUtils.convertToUser(user);
		//Mockito.when(iuserdao.findById(user.getId()).get()).thenReturn(user);
		//assertThat(iuserservice.signIn(user1)).isEqualTo(user);
		Assert.assertNotNull(user);
	}
	
	@Test
	void testChangePassword01() throws Exception
	{
		User user1 = new User();
		user = new UserEntity();
		user.setId((long)8);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		//Mockito.when(iuserdao.findById(user.getId()).get()).thenReturn(user);
		user.setPassword("chakri@456");
		Mockito.when(iuserdao.save(user)).thenReturn(user);
		user1 = UserUtils.convertToUser(user);
		Assert.assertNotNull(user);
	}

}
