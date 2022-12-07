package com.kara.studentscareer.bachelorpapel.Converter;

import com.kara.studentscareer.bachelorpapel.Dto.UserDto;
import com.kara.studentscareer.bachelorpapel.Entity.User;
import com.kara.studentscareer.bachelorpapel.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {


    @Autowired
    private UserRepository userRepository;

    public UserDto entityToDto(User user){
        UserDto dto=new UserDto();
        dto.setId(user.getUserId());
        dto.setUserName(user.getUsername());
        dto.setFName(user.getFirstName());
        dto.setLName(user.getLastname());
        return dto;
    }

   public User dtoToEntity(UserDto userDto){
        User user=userRepository.findByEmail(userDto.getEmail());
        user.setFirstName(userDto.getFName());
        user.setLastname(userDto.getLName());
        user.setUsername(userDto.getUserName());

        return user;
   }

}
