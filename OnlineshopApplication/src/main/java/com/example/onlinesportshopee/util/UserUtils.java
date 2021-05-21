package com.example.onlinesportshopee.util;
import java.util.ArrayList;
import java.util.List;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.model.User;
public class UserUtils {
	private UserUtils() {
    }
     public static List<User> convertToOrderDtoList(List<UserEntity> list){
        List<User> dtolist = new ArrayList<>();
        for(UserEntity userEntity : list) 
            dtolist.add(convertToOrder(userEntity));
        return dtolist;
    }
    
    public static UserEntity convertToOrder(User dto) {
        UserEntity user = new UserEntity();
        
        user.setId(Long.parseLong(dto.getUserId()));
        user.setPassword(dto.getPassword());
        return user;
    }        
    
    public static User convertToOrder(UserEntity userEntity) {
        User dto = new User();
        dto.setUserId(userEntity.getId().toString());
        dto.setPassword(userEntity.getPassword());
        return dto;
    }
}
