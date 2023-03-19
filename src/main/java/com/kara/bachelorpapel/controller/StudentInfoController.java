package com.kara.bachelorpapel.controller;


import com.kara.bachelorpapel.entity.StudentInfo;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.StudentInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/studentInfo")
public class StudentInfoController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentInfoServiceImpl studentInfoService;

    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }


    @PostMapping("/add")
    public String addStudentInfo(@RequestParam("am") String am,
                                 @RequestParam("entryYears") String entryYear,
                                 @RequestParam("graduationYears") String graduationYear, Model model) {
        User loggedInUser =getLoggedInUser();
        studentInfoService.addStudentInfo(am, entryYear, graduationYear, loggedInUser);
        return "addInfoProfile";
    }

    @GetMapping("/update/{am}")
    public String updateStInfo(@PathVariable(value="am") String am, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        StudentInfo studentInfo=studentInfoService.getStInfoByAm(am);
        model.addAttribute("studentInfo",studentInfo);
        return "updateStudentInfo";
    }

    @PostMapping("/update/{am}")
    public String updateStInfo(@PathVariable(value = "am") String am, @ModelAttribute("studentInfo") StudentInfo studentInfo, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        studentInfo.setAm(am);
        studentInfoService.updateStInfo(studentInfo);
        return "userProfile";
    }


    @PostMapping("/delete")
    public String deleteUsersStudentInfo(@RequestParam("am") String am, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        studentInfoService.deleteStudentInfoByAM(am);
        userRepository.save(loggedInUser);
        return "userProfile";
    }
}
