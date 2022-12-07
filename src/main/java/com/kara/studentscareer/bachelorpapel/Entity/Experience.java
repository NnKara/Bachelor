package com.kara.studentscareer.bachelorpapel.Entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@ToString
@Entity
@Table(name = "Experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Experience_Id")
    private Integer experienceId;

    @Column(name = "Company")
    private String company;

    @Column(name = "Position")
    private String position;

    @Column(name = "StartDate")
    private Integer startDate;

    @Column(name = "EndDate")
    private Integer endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @ToString.Exclude
    private User user;

}
