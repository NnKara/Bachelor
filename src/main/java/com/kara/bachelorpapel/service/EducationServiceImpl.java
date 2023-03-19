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
    public Education getEducationById(Integer id) {
        Optional<Education> optional = educationRepository.findById(id);
        Education education=null;
        if (optional.isPresent()) {
            education = optional.get();
        } else {
            throw new RuntimeException(" Education not found for id :: " + id);
        }
        return education;
    }

    @Override
    public Education updateEducation(Education education) {
        Education dbEducation=getEducationById(education.getEducationId());
        if(dbEducation==null){
            throw  new EntityNotFoundException(" Education not found for id :: " + education.getEducationId());
        }
        if(education.getUniversity()!=null){
            dbEducation.setUniversity(education.getUniversity());
        }
        if(education.getDepartment()!=null){
            dbEducation.setDepartment(education.getDepartment());
        }
        if(education.getTitle()!=null){
            dbEducation.setTitle(education.getTitle());
        }
        if(education.getCountry()!=null){
            dbEducation.setCountry(education.getCountry());
        }
        if(education.getEntryYear()!=null){
            dbEducation.setEntryYear(education.getEntryYear());
        }
        if(education.getGraduationYear()!=null) {
            dbEducation.setGraduationYear(education.getGraduationYear());
        }
        if(education.getEducationLevel()!=null){
            dbEducation.setEducationLevel(education.getEducationLevel());
        }
        educationRepository.save(dbEducation);
        return dbEducation;
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

