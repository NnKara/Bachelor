package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Experience;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.ExperienceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExperienceServiceImpl implements ExperienceService {


    @Autowired
    private ExperienceRepository experienceRepository;
    @Override
    public void addNewExperience(String company, String position, String startDate, String endDate, User loggedInUser) {
        Experience newExperience=new Experience(company,position,startDate,endDate,loggedInUser);
        experienceRepository.save(newExperience);
    }

    @Override
    public void deleteExperience(Integer id) {
        Optional<Experience> experienceToDelete=experienceRepository.findById(id);
        if(experienceToDelete.isPresent()){
            experienceRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("Experience doesn't exist!");
        }
    }
}
