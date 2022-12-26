package com.kara.studentscareer.bachelorpapel.controller;

import com.kara.studentscareer.bachelorpapel.converter.UserConverter;
import com.kara.studentscareer.bachelorpapel.dto.UserDto;
import com.kara.studentscareer.bachelorpapel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserConverter userConverter;


    //handler method to handle home page request


    //handler method to handle user registration form request

    @GetMapping
    public String showRegistrationForm( Model model) {
        UserDto userDto=new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }


    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        UserDto existingUser=userService.findByUsername(userDto.getUsername());
        if(existingUser!=null){
            result.rejectValue("username","There is already an account registered with that username");
        }
        if(result.hasErrors()){
            return "registration";
        }
        userService.save(userDto);
        return "login";
    }

    @GetMapping("/user")
    public String getUser(UserDto userDto,Model model){
        UserDto user=userService.findByUsername(userDto.getUsername());
        model.addAttribute("homePage",user);
        return "homePage";
    }



}
