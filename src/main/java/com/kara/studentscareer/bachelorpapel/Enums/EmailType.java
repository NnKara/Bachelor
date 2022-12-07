package com.kara.studentscareer.bachelorpapel.Enums;

public enum EmailType {

    PERSONAL ("Προσωπικό E-mail"),
    WORK ("Εργασιακό E-mail");

    private final String name;

    EmailType(String name){
        this.name=name;
    }
}
