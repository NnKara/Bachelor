package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(UserDto userDto);

    List<UserDto> findAllUsers();

    UserDto findUserById(Integer id);

    UserDto findByUsername(String username);
    UserDto updateUser(User updatedUser);

    void deleteUserById(Integer id);


}
