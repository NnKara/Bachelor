package com.kara.studentscareer.bachelorpapel.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum PhoneType {

        HOME ("Τηλέφωνο Οικίας"),
        WORK ("Τηλέφωνο Εργασίας"),
        MOBILE ("Κινητό Τηλέφωνο");

        private final String name;

        PhoneType(String name){
                this.name=name;
        }
        public static PhoneType findByValue(String value) {
                for (PhoneType phone : PhoneType.values()) {
            if (value.contains(phone.name)) {
                                return  phone;
                        }
                }
                return null;
        }

        @Override
        public String toString() {
                return name ;
        }
}
