package com.kara.studentscareer.bachelorpapel.dto;

import com.kara.studentscareer.bachelorpapel.enums.EducationLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EducationDto {

    private String country;
    private String department;
    private EducationLevel educationLevel;
    private Integer entryYear;
    private Integer graduationYear;
    private String title;
    private String university;
}
