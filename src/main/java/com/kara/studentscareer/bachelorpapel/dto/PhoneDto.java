package com.kara.studentscareer.bachelorpapel.dto;

import com.kara.studentscareer.bachelorpapel.enums.PhoneType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneDto {

    private String number;
    private PhoneType phoneType;

    @Override
    public String toString() {
        return "number='" + number + '\'' +
                "," + phoneType +
                '}';
    }
}
