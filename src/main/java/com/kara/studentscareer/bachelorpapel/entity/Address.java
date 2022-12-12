package com.kara.studentscareer.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.studentscareer.bachelorpapel.enums.AddressType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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


}
