package com.kara.studentscareer.bachelorpapel.Entity;


import com.kara.studentscareer.bachelorpapel.Enums.EducationLevel;
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
@Table(name = "Education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Education_Id")
    private Integer educationId;

    @Column(name = "University")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String university;

    @Column(name = "Department")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String department;

    @Column(name = "Title")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String title;

    @Column(name = "Country")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String country;

    @Column(name = "EntryYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private Integer entryYear;

    @Column(name = "GraduationYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String graduationYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

}
