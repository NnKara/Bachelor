package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(User user);

    List<UserDto> findAllUsers();
    UserDto findUserById(Integer id);

    UserDto updateUser(User updatedUser);

    void deleteUserById(Integer id);


}
