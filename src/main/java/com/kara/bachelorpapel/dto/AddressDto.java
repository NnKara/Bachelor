package com.kara.bachelorpapel.dto;

import com.kara.bachelorpapel.enums.AddressType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AddressDto {

    private int addressId;


    private String country;
    @Column(name = "City")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Pattern(regexp = "^[a-zA-Zα-ωΑ-Ω]+$", message = "Η πόλη πρέπει να περιέχει μόνο γράμματα")
    private String city;

    @Column(name = "Street", unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(min = 2, max = 50, message = "Η οδός πρέπει να έχει μήκος από {min} έως {max} χαρακτήρες")
    private String street;

    @Column(name = "StreetNumber")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Digits(integer = 5, fraction = 0, message = "Ο αριθμός της οδού πρέπει να περιέχει {integer} αριθμούς")
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
