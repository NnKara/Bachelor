package com.kara.bachelorpapel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role(String name) {
        super();
        this.name = name;
    }
}
