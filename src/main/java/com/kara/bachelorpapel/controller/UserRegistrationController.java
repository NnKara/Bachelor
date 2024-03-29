package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.converter.UserConverter;
import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.service.UserServiceImpl;
import jakarta.persistence.EntityExistsException;
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


    @GetMapping
    public String showRegistrationForm( Model model) {
        UserDto userDto=new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }


    @PostMapping
    public String registerUserAccount(@Valid @ModelAttribute("user") UserDto userDto,
                                      BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        try {
            userService.save(userDto);
            String successMessage="You have registered successfully!";
            model.addAttribute("successMessage",successMessage);
            return "login";
        } catch (EntityExistsException e) {
            String errorMessage = "Username is already taken! Please choose a different username.";
            model.addAttribute("errorMessage", errorMessage);
            return "registration";
        }
    }



}
