package com.kara.studentscareer.bachelorpapel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class StudentInfoDto {

    @NotNull
    @NotEmpty
    private String am;
    private Integer entryYear;
    private Integer graduationYear;
}
