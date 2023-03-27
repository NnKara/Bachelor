package com.kara.bachelorpapel.controller;

import com.kara.bachelorpapel.entity.Address;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.UserRepository;
import com.kara.bachelorpapel.service.AddressServiceImpl;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Size;

@Controller
@RequestMapping("/address")
@Validated
public class AddressController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressServiceImpl addressService;

//    @Autowired
//    private AddressValidator addressValidator;


    private User getLoggedInUser() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        return userRepository.findByUsername(username);
    }

    @PostMapping("/add")
    public String addUsersAddress(@RequestParam("addressType") String addressType,
                                @RequestParam("country") @NotBlank @Size(max = 2) String country,
                                @RequestParam("city") String city,
                                @RequestParam("postalCode") String postalCode,
                                @RequestParam("number") String number,
                                @RequestParam("street") String street ) {
        User loggedInUser = getLoggedInUser();
        addressService.saveNewAddress(street, number, postalCode, city, country, loggedInUser, addressType);
        return "addInfoProfile";
    }


    @GetMapping("/update/{id}")
    public String showFormUpdateAddress(@PathVariable(value = "id")Integer id, Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        Address address=addressService.getAddressById(id);
        model.addAttribute("address",address);
        return "updateAddress";
    }

    @PostMapping("/update/{id}")
    public String updateAddress(@PathVariable(value = "id") Integer id,@ModelAttribute("address") Address address,Model model){
        User loggedInUser=getLoggedInUser();
        model.addAttribute("user",loggedInUser);
        address.setAddressId(id);
        addressService.updateAddress(address);
        return "userProfile";
    }

    @PostMapping("/delete")
    public String deleteUsersAddress(@RequestParam("address") Integer addressId, Model model) {
        User loggedInUser =getLoggedInUser();
        model.addAttribute("user", loggedInUser);
        addressService.deleteAddress(addressId);
        userRepository.save(loggedInUser);
        return "userProfile";
    }


}
