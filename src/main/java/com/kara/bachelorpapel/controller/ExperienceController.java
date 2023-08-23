package com.kara.bachelorpapel.controller;


import com.kara.bachelorpapel.entity.Experience;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExperienceServiceImpl experienceService;

    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }

    @PostMapping("/add")
    public String addExperience(@RequestParam("company") String company,
                                @RequestParam("position") String position,
                                @RequestParam("startDate") String startDate,
                                @RequestParam("endDate") String endDate,
                                Model model) {
        User loggedInUser = getLoggedInUser();
        experienceService.addNewExperience(company, position, startDate, endDate, loggedInUser);
        model.addAttribute("successMessage", "Experience Added Successfully!");
        return "addInfoProfile";
    }
    @GetMapping("/update/{id}")
    public String updateExp(@PathVariable(value="id") Integer id, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        Experience exp=experienceService.getExById(id);
        model.addAttribute("experience",exp);
        return "updateExperience";
    }

    @PostMapping("/update/{id}")
    public String updateEx(@PathVariable(value = "id") Integer id,@ModelAttribute("experience") Experience experience,Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        experience.setExperienceId(id);
        experienceService.updateExp(experience);
        model.addAttribute("successMessage", "Experience Updated Successfully!");
        return "userProfile";
    }

    @PostMapping("/delete")
    public String deleteUsersExperience(@RequestParam("experience") Integer experienceId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        experienceService.deleteExperience(experienceId);
        model.addAttribute("successMessage", "Experience Deleted Successfully!");
        return "userProfile";
    }
}
