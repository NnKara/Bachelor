package com.kara.bachelorpapel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExperienceDto {

    private int experienceId;
    private String company;
    private String endDate;
    private String startDate;
    private String position;

    @Override
    public String toString() {
        return
                "Company='" + company + '\'' +
                        ", Starting Date=" + startDate +
                        ", End Date=" + endDate +
                        ", Position='" + position + '\'' +
                        '}';
    }
}
