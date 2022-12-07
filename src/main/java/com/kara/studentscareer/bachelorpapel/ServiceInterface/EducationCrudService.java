package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.Education;

import java.util.List;
import java.util.Optional;

public interface EducationCrudService {


        Education createEducation(Education education);

        List<Education> findAllEducations();

        Optional<Education>findEducationById(Integer id);

        Education updateEducationById(Education education,Integer id);

        void deleteEducationById(Integer id);
        
}
