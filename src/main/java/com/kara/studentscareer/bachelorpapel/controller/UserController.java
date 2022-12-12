package com.kara.studentscareer.bachelorpapel.controller;


import com.kara.studentscareer.bachelorpapel.converter.UserConverter;
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

    @Autowired
    private UserConverter userConverter;




    @GetMapping("/find/{id}")
    public UserDto getUserById(@PathVariable(name = "id")Integer id) {
        return userService.findUserById(id);
    }



    @PostMapping
    public UserDto createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody User user){
          return userService.updateUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable(name = "id")Integer id){
        userService.deleteUserById(id);
    }




}
