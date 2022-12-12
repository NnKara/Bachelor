package com.kara.studentscareer.bachelorpapel.utilClassCalculations;


public final class Calculations {

    private Calculations() {

    }

    public static Integer calculateYears(Integer entryYear, Integer graduationYear) {
        return graduationYear - entryYear;
    }


}
