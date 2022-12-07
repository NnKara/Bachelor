package com.kara.studentscareer.bachelorpapel.Entity;


import com.kara.studentscareer.bachelorpapel.Enums.AddressType;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@ToString
@Entity
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_id")
    private Integer addressId;

    @Column(name = "Street")
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="user_id",nullable = false)
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;


}
