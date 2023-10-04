package com.kara.bachelorpapel.dto;

import com.kara.bachelorpapel.enums.AddressType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private int addressId;


    private String country;

    private String city;

    private String street;

    private String number;

    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Override
    public String toString() {
        return
                "Country='" + country + '\'' +
                ", City='" + city + '\'' +
                ", Street='" + street + '\'' +
                ", Street Number='" + number + '\'' +
                ", Postal Code='" + postalCode + '\'' +
                ", Address Type=" + addressType +
                '}';
    }
}
