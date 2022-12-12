package com.kara.studentscareer.bachelorpapel.dto;

import com.kara.studentscareer.bachelorpapel.enums.EmailType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailDto {

    private String email;
    private EmailType emailType;
}
