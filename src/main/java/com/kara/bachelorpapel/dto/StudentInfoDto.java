package com.kara.bachelorpapel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentInfoDto {


    private Integer studentInfoId;
    private String am;
    private String entryYear;
    private String graduationYear;


    @Override
    public String toString() {
        return
                "A-M='" + am + '\'' +
                ", Entry-Year=" + entryYear +
                ", Graduation-Year=" + graduationYear +
                '}';
    }
}
