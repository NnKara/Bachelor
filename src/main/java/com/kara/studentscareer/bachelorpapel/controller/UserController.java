package com.kara.studentscareer.bachelorpapel.controller;


import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
   private UserServiceImpl userService;


    @PutMapping("/update")
    public UserDto updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
