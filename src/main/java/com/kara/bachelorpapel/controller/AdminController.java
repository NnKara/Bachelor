package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.UserService;
import com.kara.bachelorpapel.statistic.StudentAnalytics;
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

    @Autowired
    private StudentAnalytics studentAnalytics;

    @GetMapping("/users")
    public String  getAllUsers(Model model){
        List<UserDto> users=userService.findAllUsers();
        model.addAttribute("user",users);
        return "adminHomePage";
    }


    @GetMapping("/users/analytics")
    public String getAvgYearsToJob(Model model) {
        List<UserDto> users = userService.findAllUsers();
        double avgYears = studentAnalytics.getAvgYearsToFindJob(users);
        model.addAttribute("avgYearsToJob", avgYears);
        int numOfStudents = studentAnalytics.getNumContinuedStudies(users);
        model.addAttribute("numOfStContinuedStudies", numOfStudents);
        return "studentAnalytics";
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        userService.deleteUserById(id);
    }


}
