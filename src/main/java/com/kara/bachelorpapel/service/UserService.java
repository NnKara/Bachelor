package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.entity.User;

import java.util.List;

public interface UserService {

    void save(UserDto userDto);

    List<UserDto> findAllUsers();

    UserDto findByUsername(String username);
    UserDto updateUser(User user);

    void deleteUserById(Integer id);


}
