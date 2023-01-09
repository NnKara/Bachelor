package com.kara.studentscareer.bachelorpapel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "StudentInfo")
public class StudentInfo {

    @Id
    private Integer id;

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
    @MapsId
    @ToString.Exclude
    private User user;

    public StudentInfo(String am, String entryYear, String graduationYear, User user) {
        this.am = am;
        this.entryYear = entryYear;
        this.graduationYear = graduationYear;
        this.user = user;
    }
}
