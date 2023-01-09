package com.kara.studentscareer.bachelorpapel.enums;


import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum AddressType {


    HOME ("Διεύθυνση Οικίας"),
    WORK ("Διεύθυνση Εργασίας"),
    OTHER ("Άλλο");


    private final String name;

    AddressType(String name){
        this.name=name;
    }

    public static AddressType findByValue(String value) {
        for (AddressType address : AddressType.values()) {
            if (value.contains(address.name)) {
                return  address;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Type:" +
                 name + '\'';
    }
}
