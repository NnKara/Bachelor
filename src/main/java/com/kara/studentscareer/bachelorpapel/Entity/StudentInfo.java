package com.kara.studentscareer.bachelorpapel.Entity;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@DynamicInsert
@DynamicUpdate
@ToString
@Entity
@Table(name = "StudentInfo")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AM",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private String am;

    @Column(name = "EntryYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private Integer entryYear;

    @Column(name = "GraduationYear")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    private Integer graduationYear;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId
    @ToString.Exclude
    private User user;


}
