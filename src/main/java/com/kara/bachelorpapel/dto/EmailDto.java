package com.kara.bachelorpapel.dto;

import com.kara.bachelorpapel.enums.EmailType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailDto {


    private int emailId;
    private String email;
    private EmailType emailType;

    @Override
    public String toString() {
        return email;
    }
}
