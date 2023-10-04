package com.kara.bachelorpapel.dto;

import com.kara.bachelorpapel.entity.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {


    private String username;


    private String password;

    private String firstname;

    private String lastname;

    private List<EmailDto> emails;

    private List<EducationDto> educations;

    private List<PhoneDto> phones;

    private List<ExperienceDto> experiences;
    private List<AddressDto> addresses;

    private List<Role> roles;

    private StudentInfoDto studentInfo;


}
