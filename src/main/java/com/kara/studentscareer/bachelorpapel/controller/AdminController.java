package com.kara.studentscareer.bachelorpapel.controller;

import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    private UserService userService;



//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public List<UserDto> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/find/user/{id}")
    public UserDto findUserByID(@PathVariable(name = "id") Integer id){
      return   userService.findUserById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteUserById(id);
    }


}
