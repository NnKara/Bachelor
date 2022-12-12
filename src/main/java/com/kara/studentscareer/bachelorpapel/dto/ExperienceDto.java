package com.kara.studentscareer.bachelorpapel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExperienceDto {

    private String company;
    private Integer endDate;
    private Integer startDate;
    private String position;

}
