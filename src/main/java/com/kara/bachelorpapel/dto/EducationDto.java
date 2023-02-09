package com.kara.bachelorpapel.dto;

import com.kara.bachelorpapel.enums.EducationLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EducationDto {

    private String country;
    private String university;
    private String department;
    private String title;
    private String entryYear;
    private String graduationYear;
    private EducationLevel educationLevel;

    @Override
    public String toString() {
        return
                "Country='" + country + '\'' +
                ", University='" + university + '\'' +
                ", Department='" + department + '\'' +
                ", Title='" + title + '\'' +
                ", Entry-Year=" + entryYear +
                ", Graduation-Year=" + graduationYear +
                ", Education-Level=" + educationLevel +
                '}';
    }
}
