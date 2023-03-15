package com.kara.bachelorpapel.dto;

import com.kara.bachelorpapel.enums.PhoneType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhoneDto {

    private int phoneId;
    private String number;
    private PhoneType phoneType;

    @Override
    public String toString() {
        return "number='" + number + '\'' +
                "," + phoneType +
                '}';
    }
}
