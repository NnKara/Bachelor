package com.kara.studentscareer.bachelorpapel.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Integer userId;


    @Column(name = "UserName",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(max = 50)
    private String username;

    @Column(name="Email",unique = true)
    @NotBlank(message="*Το πεδίο είναι υποχρεωτικό")
    @Size(max=50)
    private String email;

    @Column(name = "Password",unique = true)
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(max = 120)
    private String password;

    @Column(name = "FirstName")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(max = 50)
    private String firstname;

    @Column(name = "LastName")
    @NotBlank(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(max = 50)
    private String lastname;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private StudentInfo studentInfo;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Education> educations;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Experience> experiences;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Email> emails;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Phone> phones;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Address> addresses;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
        this.roles.add(role);
    }



}
