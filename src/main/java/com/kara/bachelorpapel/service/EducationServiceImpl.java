package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Education;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.EducationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;
    @Override
    public void addNewEducation(String entryYear, String graduationYear,
                                String university, String department,
                                User loggedInUser, String educationLevel,
                                String title, String country) {
        Education newEducation=new Education(university,department,title,country,entryYear,graduationYear,loggedInUser,educationLevel);
        educationRepository.save(newEducation);
    }

    @Override
    public void deleteEducation(Integer educationId) {
            Optional<Education> educationToDelete=educationRepository.findById(educationId);
            if(educationToDelete.isPresent()){
                educationRepository.deleteById(educationId);
            }
            else {
                throw new EntityNotFoundException("Education doesn't exist!");
            }
        }
    }

