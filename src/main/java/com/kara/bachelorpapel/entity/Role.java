package com.kara.bachelorpapel.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Email
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

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
