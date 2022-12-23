package com.kara.studentscareer.bachelorpapel.dto;

import com.kara.studentscareer.bachelorpapel.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {


    @NotEmpty(message = "Field is required!")
    @Size(min=2,max=10,message = "Username must contain 2-10 characters")
    private String username;


    @NotEmpty(message = "Field is required!")
    @Size(min=2,max=15,message = "Password must contain 2-15 characters ")
    private String password;

    @NotEmpty(message = "Field is required!")
    @Size(min = 2,max = 15)
    private String firstname;

    @NotEmpty(message = "Field is required!")
    @Size(min = 2,max = 15)
    private String lastname;

    @javax.validation.constraints.Email(regexp = "^(.+)@(.+)$",message = "Invalid Email pattern!")
    private List<Email> emails;

    @Size(min=2,max=30,message = "Το πεδίο είναι υποχρεωτικό!")
    private List<Education> educations;

    @Pattern(regexp = "[7-9][0-9]{9}",message = "Invalid Mobile Number!")
    @Size(max=10,message = "Digits should be 10!")
    private List<Phone> phones;

    @Size(min=2,max=30,message = "Το πεδίο είναι υποχρεωτικό!")
    private List<Experience> experiences;

    private List<Address> addresses;

}
