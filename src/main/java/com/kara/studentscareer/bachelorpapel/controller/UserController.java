package com.kara.studentscareer.bachelorpapel.controller;


import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserServiceImpl userService;


    @PutMapping(value = "/update",produces = "application/json")
    public UserDto updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
