package com.kara.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "StudentInfo")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StInfo_id")
    private Integer studentInfoId;

    @Column(name = "AM",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String am;

    @Column(name = "EntryYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String entryYear;

    @Column(name = "GraduationYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String graduationYear;


    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    public StudentInfo(String am, String entryYear, String graduationYear, User user) {
        this.am = am;
        this.entryYear = entryYear;
        this.graduationYear = graduationYear;
        this.user = user;
    }

    @Override
    public String toString() {
        return
                "A-M= " + am +
                " Entry-Year= " + entryYear +
                " Graduation-Year= " + graduationYear  ;

    }
}
