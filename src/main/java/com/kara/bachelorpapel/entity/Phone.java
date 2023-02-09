package com.kara.bachelorpapel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kara.bachelorpapel.enums.PhoneType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Phone_Id")
    private Integer phoneId;

    @Column(name = "Number", unique = true)
    private String number;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;


    public Phone(String newPhone, User loggedInUser, String phoneType) {
        this.number = newPhone;
        this.user = loggedInUser;
        this.phoneType = PhoneType.findByValue(phoneType);
    }

    @Override
    public String toString() {
        return number;
    }
}
