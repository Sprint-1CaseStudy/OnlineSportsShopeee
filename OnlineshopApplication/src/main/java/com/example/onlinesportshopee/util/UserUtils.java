package com.example.onlinesportshopee.util;
import java.util.ArrayList;
import java.util.List;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.model.User;
public class UserUtils {
	private UserUtils() {
    }
     public static List<User> convertToUserDtoList(List<UserEntity> list){
        List<User> dtolist = new ArrayList<>();
        for(UserEntity userEntity : list) 
            dtolist.add(convertToUser(userEntity));
        return dtolist;
    }
    
    public static UserEntity convertToUser(User dto) {
        UserEntity user = new UserEntity();
        
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }        
    
    public static User convertToUser(UserEntity userEntity) {
        User dto = new User();
        dto.setId(userEntity.getId());
        dto.setUsername(userEntity.getUsername());
        dto.setPassword(userEntity.getPassword());
        return dto;
    }
}
