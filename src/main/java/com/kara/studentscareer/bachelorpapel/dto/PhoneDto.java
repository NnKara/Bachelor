package com.kara.studentscareer.bachelorpapel.dto;

import com.kara.studentscareer.bachelorpapel.enums.PhoneType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneDto {

    private Integer number;
    private PhoneType phoneType;
}
