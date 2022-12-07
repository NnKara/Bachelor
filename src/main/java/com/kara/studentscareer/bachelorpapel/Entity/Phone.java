package com.kara.studentscareer.bachelorpapel.Entity;

import com.kara.studentscareer.bachelorpapel.Enums.PhoneType;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@ToString
@Entity
@Table(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Phone_Id")
    private Integer phoneId;

    @Column(name = "Number",unique = true)
    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;




}
