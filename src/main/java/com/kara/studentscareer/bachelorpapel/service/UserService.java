package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;

import java.util.List;

public interface UserService {

    User save(UserDto userDto);

    List<UserDto> findAllUsers();

    UserDto findUserById(Integer id);

    UserDto findByUsername(String username);
    UserDto updateUser(User updatedUser);

    void deleteUserById(Integer id);


}
