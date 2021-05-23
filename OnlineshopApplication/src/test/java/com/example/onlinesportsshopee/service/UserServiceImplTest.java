package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.onlinesportshopee.dao.IUserRepository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.services.IUserService;

class UserServiceImplTest {

	@MockBean
	IUserRepository iuserdao;
	
	
	@Autowired
	IUserService iuserservice;
	
	UserEntity user=null;
	
	@Test
	void testAddUser01() throws UserException
	{
		user = new UserEntity();
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		Mockito.when(iuserdao.saveAndFlush(user)).thenReturn(user);
		assertNotNull(user);
		//assertThat(iuserservice.addUser(user)).isEqualTo(user);
	}
	
	@Test
	void testSignInUser01() throws UserException
	{
		user = new UserEntity();
		user.setId((long)6);
		user.setPassword("chakri@123");
		
		Mockito.when(iuserdao.findById(user.getId()).get()).thenReturn(user);
		//assertThat(iuserservice.signIn(user)).isEqualTo(user);
	}
	
	@Test
	void testChangePassword01() throws UserException
	{
		user = new UserEntity();
		user.setId((long)8);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		Mockito.when(iuserdao.findById(user.getId()).get()).thenReturn(user);
		user.setPassword("chakri@456");
		Mockito.when(iuserdao.save(user)).thenReturn(user);
		//assertThat(iuserservice.changePassword((long)1,user)).isEqualTo(user);
	}
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
