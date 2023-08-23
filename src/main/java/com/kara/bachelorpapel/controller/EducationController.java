package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.entity.Education;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.EducationServiceImpl;
import com.kara.bachelorpapel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/education")
public class EducationController {


    @Autowired
    private EducationServiceImpl educationService;

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserRepository userRepository;


    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }

    @PostMapping("/add")
    public String addUsersEducation(@RequestParam("educationLevel") String educationLevel,
                                    @RequestParam("university") String university,
                                    @RequestParam("department") String department,
                                    @RequestParam("title") String title,
                                    @RequestParam("entryYear") String entryYear,
                                    @RequestParam("studyCountry") String country,
                                    @RequestParam("graduationYear") String graduationYear,
                                    Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User loggedInUser = userRepository.findByUsername(username);
        educationService.addNewEducation(entryYear, graduationYear, university, department, loggedInUser, educationLevel, title, country);
        model.addAttribute("successMessage", "Education Added Successfully!");
        return "addInfoProfile";
    }

    @GetMapping("/update/{id}")
    public String updateEducation(@PathVariable(value="id") Integer id, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        Education education=educationService.getEducationById(id);
        model.addAttribute("education",education);
        return "updateEducation";
    }

    @PostMapping("/update/{id}")
    public String updateEducation(@PathVariable(value = "id") Integer id, @ModelAttribute("education") Education education, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        education.setEducationId(id);
        educationService.updateEducation(education);
        model.addAttribute("successMessage", "Education Updated Successfully!");
        return "userProfile";
    }

    @PostMapping("/delete")
    public String deleteUsersEducation(@RequestParam("education") Integer educationId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        educationService.deleteEducation(educationId);
        model.addAttribute("successMessage", "Education Deleted Successfully!");
        return "userProfile";
    }
}
