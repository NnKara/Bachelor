package com.kara.studentscareer.bachelorpapel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

}
