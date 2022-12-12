package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {


        Education createEducation(Education education);

        List<Education> findAllEducations();

        Optional<Education>findEducationById(Integer id);

        Education updateEducationById(Education education,Integer id);

        void deleteEducationById(Integer id);
        
}
