package com.kara.studentscareer.bachelorpapel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum EmailType {

    PERSONAL ("Προσωπικό E-mail"),
    WORK ("Εργασιακό E-mail");

    private final String name;

    EmailType(String name){
        this.name=name;
    }
}
