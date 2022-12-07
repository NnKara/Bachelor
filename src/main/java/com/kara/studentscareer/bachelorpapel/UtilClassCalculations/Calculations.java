package com.kara.studentscareer.bachelorpapel.UtilClassCalculations;


import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public final class Calculations {



   public static Integer calculateYears(Integer entryYear,Integer graduationYear){
       return graduationYear-entryYear;
   }








}
