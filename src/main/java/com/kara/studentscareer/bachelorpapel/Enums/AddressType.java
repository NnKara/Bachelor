package com.kara.studentscareer.bachelorpapel.Enums;


public enum AddressType {


    HOME ("Διεύθυνση Οικίας"),
    WORK ("Διεύθυνση Εργασίας"),
    OTHER ("Άλλο");

    private final String name;

    AddressType(String name){
        this.name=name;
    }



}
