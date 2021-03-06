package com.example.onlinesportsshopee.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.IUserRepository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;


@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootConfiguration
@EnableJpaRepositories(basePackages = {"com.example.onlinesportsshopee.*"})
class UserDaoTest {
	
	@Autowired 
	IUserRepository iuserdao;
	
	@Autowired
	TestEntityManager testEntityManager;

	@Test
	void testAddUser01() throws UserException
	{
		UserEntity user = new UserEntity(); 
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		UserEntity saveInDb = testEntityManager.persist(user);
		UserEntity getInDb = iuserdao.findById(saveInDb.getId()).get();
		//assertEquals(getInDb, saveInDb);
		Assert.assertEquals(getInDb, saveInDb);
	}
	
	void testSignInUser01() throws UserException
	{
		UserEntity user = new UserEntity();
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		UserEntity getFromDb = iuserdao.findById(user.getId()).get();
		//assertEquals(getFromDb, user);
		Assert.assertEquals(user, getFromDb);
	}
	
	/*
	@Test
	void testChangePasswordUser01() throws UserException
	{
		UserEntity user = new UserEntity();
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		
		UserEntity getFromDb = iuserdao.findById(user.getId()).get();
		getFromDb.setPassword("Chinnu@456");
		testEntityManager.persist(getFromDb);		
		assertThat(getFromDb.getPassword()).isEqualTo("Chinnu@456");
	}
	*/
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
