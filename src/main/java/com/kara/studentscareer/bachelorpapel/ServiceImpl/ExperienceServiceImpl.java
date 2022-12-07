package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.Experience;
import com.kara.studentscareer.bachelorpapel.Repository.ExperienceRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.ExperienceCrudService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class ExperienceServiceImpl implements ExperienceCrudService {

    private ExperienceRepository experienceRepository;

    @Override
    public Experience createExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public List<Experience> findAllExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> findExperienceById(Integer id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience updateExperience(Integer id, Experience updatedExperience) {
        Optional<Experience> isThereExperience=findExperienceById(id);
        if(isThereExperience.isEmpty()){
            throw new EntityNotFoundException("There is no experience with this ID: "+id);
        }
        Experience existingExperience=isThereExperience.get();
        existingExperience.setCompany(updatedExperience.getCompany());
        existingExperience.setPosition(updatedExperience.getPosition());
        existingExperience.setStartDate(updatedExperience.getStartDate());
        existingExperience.setEndDate(updatedExperience.getEndDate());
        experienceRepository.save(existingExperience);
        return existingExperience;
    }

    @Override
    public void deleteExperienceById(Integer id) {
        experienceRepository.deleteById(id);
    }
}
