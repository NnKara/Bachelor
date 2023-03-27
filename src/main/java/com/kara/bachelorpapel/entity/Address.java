package com.kara.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.bachelorpapel.enums.AddressType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_id")
    private Integer addressId;

    @Column(name = "Street", unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(min = 2, max = 50, message = "Η οδός πρέπει να έχει μήκος από {min} έως {max} χαρακτήρες")
    private String street;


    @Column(name = "StreetNumber")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Digits(integer = 5, fraction = 0, message = "Ο αριθμός της οδού πρέπει να περιέχει {integer} αριθμούς")
    private String number;



    @Column(name = "PostalCode")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String postalCode;

    @Column(name = "City")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Pattern(regexp = "^[a-zA-Zα-ωΑ-Ω]+$", message = "Η πόλη πρέπει να περιέχει μόνο γράμματα")
    private String city;


    @Column(name = "Country")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String country;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id")
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    public Address( String street, String number, String postalCode, String city, String country, User user, String addressType) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.user = user;
        this.addressType = AddressType.findByValue(addressType);
    }

    @Override
    public String toString() {
        return
                " Street= " + street +
                " / City= " + city +
                " / Country= " + country ;
    }
}
