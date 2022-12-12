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



    @GetMapping("/admin/users")
    public List<UserDto> getAllUsers(){
        return userService.findAllUsers();
    }


}
