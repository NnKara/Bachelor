package com.kara.studentscareer.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.studentscareer.bachelorpapel.enums.EmailType;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Email_Id")
    private Integer emailId;

    @javax.validation.constraints.Email
    @Column(name = "Email",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String email;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private EmailType emailType;

}
