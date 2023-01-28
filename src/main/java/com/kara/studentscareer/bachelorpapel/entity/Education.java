package com.kara.studentscareer.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.studentscareer.bachelorpapel.enums.EducationLevel;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private String entryYear;

    @Column(name = "GraduationYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String graduationYear;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private EducationLevel educationLevel;

    public Education( String university, String department, String title, String country, String entryYear, String graduationYear, User user, String educationLevel) {
        this.university = university;
        this.department = department;
        this.title = title;
        this.country = country;
        this.entryYear = entryYear;
        this.graduationYear = graduationYear;
        this.user = user;
        this.educationLevel = EducationLevel.findByValue(educationLevel);
    }

    @Override
    public String toString() {
        return
                " University: " + university +
                " Department: " + department +
                " Title: : " + title +
                " Country: " + country +
                " Entry Year: " + entryYear +
                " Graduation Year: " + graduationYear +
                " Education Level: " + educationLevel ;
    }
}
