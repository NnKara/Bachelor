package com.kara.studentscareer.bachelorpapel.Enums;

public enum PhoneType {

        HOME ("Τηλέφωνο Οικίας"),
        WORK ("Τηλέφωνο Εργασίας"),
        MOBILE ("Κινητό Τηλέφωνο");

        private final String name;

        PhoneType(String name){
                this.name=name;
        }
}
