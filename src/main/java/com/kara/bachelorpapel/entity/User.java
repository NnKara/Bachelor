package com.kara.bachelorpapel.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Integer userId;


    @Column(name = "username",unique = true)
    @NotEmpty(message = "Το πεδίο είναι υποχρεωτικό!")
    @Size(min=2,max=10,message = "Το πεδίο πρέπει να περιέχει 2-10 χαρακτήρες!")
    private String username;


    @Column(name = "Password",unique = true)
    @NotEmpty(message = "*Το πεδίο είναι υποχρεωτικό!")
    @Size(min=2,max=15,message = "Το πεδίο πρέχει να περιέχει 2-15 χαρακτήρες ")
    private String password;

    @Column(name = "FirstName")
    @NotEmpty(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(min = 2,max = 15)
    private String firstname;

    @Column(name = "LastName")
    @NotEmpty(message = "*Το πεδίο είναι υποχρεωτικό")
    @Size(min = 2,max = 15)
    private String lastname;


    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE,orphanRemoval = true)
    private StudentInfo studentInfo;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Email> emails;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Phone> phones;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles=new ArrayList<>() ;

}
