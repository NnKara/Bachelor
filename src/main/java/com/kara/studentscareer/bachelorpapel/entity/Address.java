package com.kara.studentscareer.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.studentscareer.bachelorpapel.enums.AddressType;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

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

    @Column(name = "Street",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String street;

    @Column(name = "StreetNumber")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String number;

    @Column(name = "PostalCode")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String postalCode;

    @Column(name = "City")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
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
