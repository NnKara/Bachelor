package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.converter.UserConverter;
import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.AddressRepository;
import com.kara.bachelorpapel.repository.EmailRepository;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ExperienceServiceImpl experienceService;
    @Autowired
    private EducationServiceImpl educationService;
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private StudentInfoServiceImpl studentInfoService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PhoneServiceImpl phoneService;
    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private AddressServiceImpl addressService;

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private AddressRepository addressRepository;


    @GetMapping
    public String showHomePage(Model model) {
        User user = getLoggedInUser();
        UserDto userDto = userConverter.entityToDto(user);
        model.addAttribute("user", userDto);
        return "userProfile";
    }

    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }


    @GetMapping("/delete")
    public String deleteUsersEmails(Model model) {
        User user= getLoggedInUser();
        UserDto loggedUser=userConverter.entityToDto(user);
        model.addAttribute("user", loggedUser);
        return "deletePage";
    }


    @GetMapping("/add")
    public String showUpdateForm(Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        return "addInfoProfile";
    }


}



