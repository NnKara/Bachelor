package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Experience;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.ExperienceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Experience getExById(Integer id) {
        Optional<Experience> optional = experienceRepository.findById(id);
        Experience experience=null;
        if (optional.isPresent()) {
            experience = optional.get();
        } else {
            throw new RuntimeException(" Experience not found for id :: " + id);
        }
        return experience;
    }

    @Override
    public List<Experience> getAllExp() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience updateExp(Experience experience) {
        Experience dbExp=getExById(experience.getExperienceId());
        if(dbExp==null){
            throw new EntityNotFoundException(" Experience not found for id :: " + experience.getExperienceId());
        }
        if(experience.getCompany()!=null){
            dbExp.setCompany(experience.getCompany());
        }
        if(experience.getPosition()!=null){
            dbExp.setPosition(experience.getPosition());
        }
        if(experience.getStartDate()!=null){
            dbExp.setStartDate(experience.getStartDate());
        }
        if(experience.getEndDate()!=null){
            dbExp.setEndDate(experience.getEndDate());
        }

        experienceRepository.save(dbExp);
        return dbExp;
    }

    @Override
    public void deleteExperience(Integer id) {
        Experience experienceToDelete=getExById(id);
        if(experienceToDelete!=null){
            experienceRepository.deleteById(id);
        }
        else {
            throw new EntityNotFoundException("Experience doesn't exist!");
        }
    }
}
