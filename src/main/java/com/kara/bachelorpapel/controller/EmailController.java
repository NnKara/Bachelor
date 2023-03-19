package com.kara.bachelorpapel.controller;


import com.kara.bachelorpapel.entity.Email;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailServiceImpl emailService;

    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }

    @PostMapping("/add")
    public String addUsersEmail(@RequestParam("email") String email,
                                @RequestParam("emailType") String emailType) {
        User loggedInUser = getLoggedInUser();
        emailService.addEmailWithType(email, loggedInUser, emailType);
        return "addInfoProfile";
    }



    @GetMapping("/update/{id}")
    public String updateEmail(@PathVariable(value="id") Integer id, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        Email email=emailService.getEmailById(id);
        model.addAttribute("email",email);
        return "updateEmail";
    }

    @PostMapping("/update/{id}")
    public String updateEmail(@PathVariable(value = "id") Integer id, @ModelAttribute("email") Email email, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        email.setEmailId(id);
        emailService.updateEmail(email);
        return "userProfile";
    }

    @PostMapping("/delete")
    public String deleteUsersEmail(@RequestParam("email") Integer emailId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        emailService.deleteEmail(emailId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }
}
