package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.entity.Phone;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phone")
public class PhoneController {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PhoneServiceImpl phoneService;


    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }

    @PostMapping("/add")
    public String addUsersPhone(@RequestParam("phone") String phone,
                                @RequestParam("phoneType") String phoneType,
                                Model model) {

        User loggedInUser = getLoggedInUser();
        phoneService.addPhone(phone, loggedInUser, phoneType);
        model.addAttribute("successMessage", "Phone Added Successfully!");
        return "addInfoProfile";
    }


    @GetMapping("/update/{id}")
    public String updatePhone(@PathVariable(value="id") Integer id, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        Phone phone=phoneService.getPhoneById(id);
        model.addAttribute("phone",phone);
        return "updatePhone";
    }

    @PostMapping("/update/{id}")
    public String updatePhone(@PathVariable(value = "id") Integer id,@ModelAttribute("phone") Phone phone,Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        phone.setPhoneId(id);
        phoneService.updatePhone(phone);
        model.addAttribute("successMessage", "Phone Updated Successfully!");
        return "userProfile";
    }

    @PostMapping("/delete")
    public String deleteUsersPhone(@RequestParam("phone") Integer phoneId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        phoneService.deletePhone(phoneId);
        model.addAttribute("successMessage", "Phone Deleted Successfully!");
        return "userProfile";
    }
}
