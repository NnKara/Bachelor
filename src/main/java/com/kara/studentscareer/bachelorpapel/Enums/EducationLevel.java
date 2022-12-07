package com.kara.studentscareer.bachelorpapel.Enums;

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
