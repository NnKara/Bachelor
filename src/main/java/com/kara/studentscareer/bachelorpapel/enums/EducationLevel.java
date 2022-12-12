package com.kara.studentscareer.bachelorpapel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum EducationLevel {

    UNDERGRADUATE ("Προπτυχιακό"),
    POSTGRADUATE("Μεταπτυχιακό"),
    DOCTORAL("Διδακτορικό"),
    POSTDOCTORAL("Μεταδιδακτορικό");



    private final String name;


    EducationLevel(String name){
        this.name=name;
    }


}
