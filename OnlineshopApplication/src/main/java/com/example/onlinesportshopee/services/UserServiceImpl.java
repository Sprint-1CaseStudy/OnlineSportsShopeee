package com.example.onlinesportshopee.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.controller.UserController;
import com.example.onlinesportshopee.dao.IUserRepository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserException;
import com.example.onlinesportshopee.model.User;
import com.example.onlinesportshopee.util.UserUtils;

 

@Service
public class UserServiceImpl implements IUserService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    
    @Autowired
    private IUserRepository Userrepo;


    @Override
	public User addUser(UserEntity user) throws UserException {
    	LOGGER.info("addUser() service is initiated");
    	UserEntity userEntity;
		if(user==null)
			userEntity=null;
		else {
			userEntity=Userrepo.save(user);	
		}
		LOGGER.info("addUser() service has executed");
		return UserUtils.convertToOrder(userEntity);
	}
    
    @Override
    public UserEntity signIn(UserEntity user) throws UserException {
    	LOGGER.info("signin() service is initiated");
        Long userid = user.getId();
        String password = user.getPassword();
        UserEntity useridrepo = Userrepo.findById(userid).orElse(null);
        if (useridrepo == null)
        {
            String usernotfound = "No user found by the userid "+userid;
            throw new UserException(usernotfound);
        }
        else 
        {
            if(userid.equals(useridrepo.getId()) && password.equals(useridrepo.getPassword())) 
            {
            	LOGGER.info("signin() service has Executed");
                return useridrepo;
            }
            else {
            	throw new UserException("User name and password are invalid");
            }
        }
    }

 

    @Override
    public String signOut(UserEntity user) {
    	LOGGER.info("signout() service is initiated");
        return "Signout Successfully";
    }

 

    @Override
    public User changePassword(long id, UserEntity user) throws UserException {
    	LOGGER.info("changepassword() service is initiated");
        UserEntity userEnti;
        UserEntity changePassword = Userrepo.findById(id).orElse(null);
        if(changePassword == null)
        {
            String usernotfound = "No user found by the userid ";
            throw new UserException(usernotfound);
        }
        else userEnti = Userrepo.save(user);
        LOGGER.info("changepassword() service has Executed");
        return UserUtils.convertToOrder(userEnti);
    }

 

}