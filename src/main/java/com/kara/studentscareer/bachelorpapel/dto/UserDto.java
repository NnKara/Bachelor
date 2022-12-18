package com.kara.studentscareer.bachelorpapel.dto;

import com.kara.studentscareer.bachelorpapel.entity.Education;
import com.kara.studentscareer.bachelorpapel.entity.Email;
import com.kara.studentscareer.bachelorpapel.entity.Experience;
import com.kara.studentscareer.bachelorpapel.entity.Phone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private List<Email> emails;
    private List<Education> educations;
    private List<Phone> phones;
    private List<Experience> experiences;






}
