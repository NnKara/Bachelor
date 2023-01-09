package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Education;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;
    @Override
    public void addNewEducation(String entryYear, String graduationYear,
                                String university, String department,
                                User loggedInUser,String educationLevel,
                                String title,String country) {
        Education newEducation=new Education(university,department,title,country,entryYear,graduationYear,loggedInUser,educationLevel);
        educationRepository.save(newEducation);
    }

    @Override
    public void deleteEducation() {

    }
}
