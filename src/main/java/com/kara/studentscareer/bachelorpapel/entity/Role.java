package com.kara.studentscareer.bachelorpapel.entity;

import lombok.*;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Role")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    public Role(String name) {
        super();
        this.name = name;
    }
}
