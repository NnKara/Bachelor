package com.kara.studentscareer.bachelorpapel.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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

    @Transient
    private String confirmPassword;


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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles=new ArrayList<>() ;

    public <T> User(Collection<Education> educations, String username, String password, String firstname, String lastname, List<Phone> phones, List<Experience> experiences, List<Email> emails, List<T> role) {

    }

    public <T> User(String firstname, String username, String password, String lastname, List<T> role) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User that = (User) o;
        return userId != null && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
