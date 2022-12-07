package com.kara.studentscareer.bachelorpapel.Entity;


import com.kara.studentscareer.bachelorpapel.Enums.EmailType;
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
@Table(name = "Email")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Email_Id")
    private Integer emailId;

    @Column(name = "Email",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String email;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private EmailType emailType;

}
