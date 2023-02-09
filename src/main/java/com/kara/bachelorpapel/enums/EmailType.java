package com.kara.bachelorpapel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum EmailType {

    PERSONAL ("Προσωπικό E-mail"),
    WORK ("Εργασιακό E-mail");

    private final String name;

    EmailType(String name){
        this.name=name;
    }

    public static EmailType findByValue(String value) {
        for (EmailType email : EmailType.values()) {
            if (value.contains(email.name)) {
               return  email;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
