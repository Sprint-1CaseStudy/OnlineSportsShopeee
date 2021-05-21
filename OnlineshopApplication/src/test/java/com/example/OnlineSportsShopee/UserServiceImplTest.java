package com.example.OnlineSportsShopee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.services.IUserService;

class UserServiceImplTest {

	@Autowired
	IUserService service;
	
	UserEntity user = null;
	
	@BeforeAll
	public static void init() {
		//LOGGER.info("User Testing Initiated");
	}
	
	
	@Test
	void testaddUser01() throws UserException {
	 //LOGGER.info("Testing testaddUser01()");
		user = new UserEntity((long)121,"Azeem" ,"Azeem@2001");
		assertNotNull(service.addUser(user));
	}
	
	@Test
	void testaddUser02() throws UserException {
	 //LOGGER.info("Testing testaddUser02()");
		user = new UserEntity((long)122,"Azeem", "Azeem@2003");
		try {
			service.addUser(user);
		} catch (UserException exception) {
			assertEquals("User Name already exists, Try another name", exception.getMessage());
		}
	}
	
	@Test
	void testaddUser03() throws UserException {
	 //LOGGER.info("Testing testaddUser03()");
		user = new UserEntity((long)123,null,"Babu@2004");
		try {
			service.addUser(user);
		} catch (UserException exception) {
			assertEquals("Username cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testaddUser04() throws UserException {
	 //LOGGER.info("Testing testaddUser04()");
		user = new UserEntity((long)125,"Raja",null);
		try {
			service.addUser(user);
		} catch (UserException exception) {
			assertEquals("Password cannot be empty", exception.getMessage());
		}
	}
	
	//signIn
	
	@Test
	void testSignInUser01() throws UserException {
	 //LOGGER.info("Testing testaddUser01()");
		user = new UserEntity((long)121,"Azeem" ,"Azeem@2001");
		assertNotNull(service.addUser(user));
	}
	
	void testSignInUser02() throws UserException {
		 //LOGGER.info("Testing testaddUser01()");
			user = new UserEntity((long)0,"Azeem" ,"Azeem@2001");
			try {
				service.signIn(user);
			} catch (UserException exception) {
				assertEquals("UserId cannot be empty", exception.getMessage());
			}
		}
	
	//changepassword
	
	@Test
	void testChangePasswordUser01() throws UserException {
	 //LOGGER.info("Testing testsignInUser01()");
		user = new UserEntity((long)121,"Pooja" ,"Pooja@2001");
		assertNotNull(service.changePassword(user.getId(),user));
	}
	
	@Test
	void testChangePasswordUser02() throws UserException {
		//LOGGER.info("Testing testAddUser06()");
		user = new UserEntity((long)0,"chakri" ,null);
		try {
			service.changePassword(user.getId(),user);
		} catch (UserException exception) {
			assertEquals("UserId cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void testChangePasswordUser03() throws UserException {
		//LOGGER.info("Testing testAddUser06()");
		user = new UserEntity((long)121,"chakri" ,null);
		try {
			service.changePassword(user.getId(),user);
		} catch (UserException exception) {
			assertEquals("Password cannot be empty", exception.getMessage());
		}
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
