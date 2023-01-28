package com.kara.studentscareer.bachelorpapel.controller;

import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.repository.UserRepository;
import com.kara.studentscareer.bachelorpapel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String  getAllUsers(Model model){
        List<UserDto> user=userService.findAllUsers();
        model.addAttribute("user",user);
        return "adminHomePage";
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteUserById(id);
    }


}
