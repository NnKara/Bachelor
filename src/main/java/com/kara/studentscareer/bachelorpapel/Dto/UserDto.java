package com.kara.studentscareer.bachelorpapel.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Integer id;
    @NotNull
    @NotEmpty
    private String userName;
    private String fName;
    private String lName;
    private String email;



}
