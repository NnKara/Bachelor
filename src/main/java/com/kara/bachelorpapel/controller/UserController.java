package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.converter.UserConverter;
import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.entity.Address;
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
import org.springframework.web.bind.annotation.*;


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
        model.addAttribute("user", user);
        return "deletePage";
    }


    @GetMapping("/update")
    public String showUpdateForm(Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        return "addInfoProfile";
    }

    @GetMapping("/update/address/{id}")
    public String showFormUpdateAddress(@PathVariable(value = "id")Integer id,Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        Address address=addressService.getAddressById(id);
        model.addAttribute("address",address);
        return "updateAddress";
    }

    @PostMapping("/update/address/{id}")
    public String updateAddress(@PathVariable(value = "id") Integer id,@ModelAttribute("address") Address address,Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        address.setAddressId(id);
        addressService.updateAddress(address);
        return "userProfile";
    }

    @PostMapping("/add/email")
    public String addUsersEmail(@RequestParam("email") String email,
                                   @RequestParam("emailType") String emailType) {
        User loggedInUser = getLoggedInUser();
        emailService.addEmailWithType(email, loggedInUser, emailType);
        return "addInfoProfile";
    }

    @PostMapping("/add/phone")
    public String addUsersPhone(@RequestParam("phone") String phone,
                                   @RequestParam("phoneType") String phoneType) {

        User loggedInUser = getLoggedInUser();
        phoneService.addPhone(phone, loggedInUser, phoneType);
        return "addInfoProfile";
    }

    @PostMapping("/add/address")
    public String addUsersPhone(@RequestParam("addressType") String addressType,
                                   @RequestParam("country") String country,
                                   @RequestParam("city") String city,
                                   @RequestParam("postalCode") String postalCode,
                                   @RequestParam("number") String number,
                                   @RequestParam("street") String street) {

        User loggedInUser = getLoggedInUser();
        addressService.saveNewAddress(street, number, postalCode, city, country, loggedInUser, addressType);
        return "addInfoProfile";
    }

    @PostMapping("/add/education")
    public String addUsersEducation(@RequestParam("educationLevel") String educationLevel,
                                       @RequestParam("university") String university,
                                       @RequestParam("department") String department,
                                       @RequestParam("title") String title,
                                       @RequestParam("entryYear") String entryYear,
                                       @RequestParam("studyCountry") String country,
                                       @RequestParam("graduationYear") String graduationYear) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User loggedInUser = userRepository.findByUsername(username);
        educationService.addNewEducation(entryYear, graduationYear, university, department, loggedInUser, educationLevel, title, country);
        return "addInfoProfile";
    }

    @PostMapping("/add/studentInfo")
    public String addStudentInfo(@RequestParam("am") String am,
                                 @RequestParam("entryYears") String entryYear,
                                 @RequestParam("graduationYears") String graduationYear,Model model) {
        User loggedInUser =getLoggedInUser();
            studentInfoService.addStudentInfo(am, entryYear, graduationYear, loggedInUser);
            return "addInfoProfile";
        }

    @PostMapping("/add/experience")
    public String addExperience(@RequestParam("company") String company,
                                 @RequestParam("position") String position,
                                 @RequestParam("startDate") String startDate,
                                 @RequestParam("endDate") String endDate) {
        User loggedInUser = getLoggedInUser();
        experienceService.addNewExperience(company, position, startDate, endDate, loggedInUser);
        return "addInfoProfile";
    }

    @PostMapping("/delete/email")
    public String deleteUsersEmail(@RequestParam("email") Integer emailId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        emailService.deleteEmail(emailId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }

    @PostMapping("/delete/phone")
    public String deleteUsersPhone(@RequestParam("phone") Integer phoneId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        phoneService.deletePhone(phoneId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }

    @PostMapping("/delete/address")
    public String deleteUsersAddress(@RequestParam("address") Integer addressId, Model model) {
        User loggedInUser =getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        addressService.deleteAddress(addressId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }

    @PostMapping("/delete/experience")
    public String deleteUsersExperience(@RequestParam("experience") Integer experienceId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        experienceService.deleteExperience(experienceId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }

    @PostMapping("/delete/education")
    public String deleteUsersEducation(@RequestParam("education") Integer educationId, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        educationService.deleteEducation(educationId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }

    @PostMapping("/delete/studentInfo")
    public String deleteUsersStudentInfo(@RequestParam("am") String am, Model model) {
        User loggedInUser = getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        studentInfoService.deleteStudentInfoByAM(am);
        userRepository.save(loggedInUser);
        return "userProfile";
    }




}



