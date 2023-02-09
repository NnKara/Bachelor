package com.kara.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.bachelorpapel.enums.EmailType;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Email")
public class Email {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Email_Id")
    private Integer emailId;


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


    public Email(String newEmail, User loggedInUser,String emailType) {
        this.email=newEmail;
        this.user=loggedInUser;
        this.emailType= EmailType.findByValue(emailType);
    }

    @Override
    public String toString() {
        return email ;
    }
}
