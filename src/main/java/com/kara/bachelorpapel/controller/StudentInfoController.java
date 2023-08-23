package com.kara.bachelorpapel.controller;


import com.kara.bachelorpapel.entity.StudentInfo;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.StudentInfoRepository;
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
    @Autowired
    private StudentInfoRepository studentInfoRepository;

    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }




    @PostMapping("/add")
    public String addStudentInfo(@RequestParam("am") String am,
                                 @RequestParam("entryYears") String entryYear,
                                 @RequestParam("graduationYears") String graduationYear, Model model) {
        try {
            User loggedInUser = getLoggedInUser();
            studentInfoService.addStudentInfo(am, entryYear, graduationYear, loggedInUser);
            model.addAttribute("successMessage", "Student-Info Added Successfully!");
        }catch(RuntimeException e) {
            model.addAttribute("errorMessage",e.getMessage());
        }
        return "addInfoProfile";
    }

    @GetMapping("/update/{id}")
    public String updateStInfo(@PathVariable(value="id") Integer id, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        StudentInfo studentInfo=studentInfoService.getStInfoById(id);
        model.addAttribute("studentInfo",studentInfo);
        return "updateStudentInfo";
    }

    @PostMapping("/update/{id}")
    public String updateStInfo(@PathVariable(value = "id") Integer id, @ModelAttribute("studentInfo") StudentInfo studentInfo, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        studentInfo.setStudentInfoId(id);
        studentInfoService.updateStInfo(studentInfo);
        model.addAttribute("successMessage", "Student-Info Updated Successfully!");
        return "userProfile";
    }


    @PostMapping("/delete")
    public String deleteUsersStInfo(@RequestParam("studentInfo") Integer stInfoId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        studentInfoService.deleteStInfo(loggedInUser,stInfoId);
        model.addAttribute("successMessage", "Student-Info Deleted Successfully!");
        return "redirect:/user";
    }
}
