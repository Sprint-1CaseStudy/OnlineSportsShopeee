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
    public User addUser(User user) throws UserException {
        LOGGER.info("addUser() service is initiated");
        UserEntity userEntity = UserUtils.convertToUserEntity(user);
        UserEntity userEnti;
        User existUser = null;
        if(UserValidationimpl.validateUser(userEntity) == null)
            userEnti=null;
        else {
                existUser = Userrepo.findByUserName(userEntity.getUsername());
                if(existUser != null)    throw new UserException("User Name already exists, Try another name");
                else userEnti=Userrepo.save(userEntity);    
        }
        LOGGER.info("addUser() service has executed");
        return UserUtils.convertToUser(userEnti);
    }
    
    @Override
    public User signIn(User user) throws UserException {
        LOGGER.info("signin() service is initiated");
        UserEntity userEntity = UserUtils.convertToUserEntity(user);
        UserEntity useridrepo = Userrepo.findById(userEntity.getId()).get();
        if (useridrepo == null)
        {
            String usernotfound = "No user found by the userid "+user.getId();
            throw new UserException(usernotfound);
        }
        else 
        {
            if(user.getId().equals(useridrepo.getId()) && user.getPassword().equals(useridrepo.getPassword())) 
            {
                LOGGER.info("signin() service has Executed");
                return UserUtils.convertToUser(useridrepo);
            }
            else {
                throw new UserException("User name and password are invalid");
            }
        }
    }

 

    @Override
    public String signOut(User user) {
        LOGGER.info("signout() service is initiated");
        return "Signout Successfully";
    }

 

    @Override
    public User changePassword(Long id, User user) throws UserException {
        LOGGER.info("changepassword() service is initiated");
        UserEntity userEntity = UserUtils.convertToUserEntity(user);
        if( id == 0 || userEntity.getPassword() == null) throw new UserException("Userid or password cannot be empty");
        UserEntity userEnti;
        UserEntity changePassword = Userrepo.findById(id).orElse(null);
        if(changePassword == null)
        {
            String usernotfound = "No user found by the userid ";
            throw new UserException(usernotfound);
        }
        else userEnti = Userrepo.save(userEntity);
        LOGGER.info("changepassword() service has Executed");
        return UserUtils.convertToUser(userEnti);
    }
}