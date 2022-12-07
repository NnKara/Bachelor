package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.Education;
import com.kara.studentscareer.bachelorpapel.Repository.EducationRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.EducationCrudService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationCrudService {

    private EducationRepository educationRepository;


    @Override
    public Education createEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public List<Education> findAllEducations() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> findEducationById(Integer id) {
        return educationRepository.findById(id);
    }

    @Override
    public Education updateEducationById(Education updatedEducation, Integer id) {
        Optional<Education> isThereEducation=findEducationById(id);
        if(isThereEducation.isEmpty()){
            throw new EntityNotFoundException("There is no Education with this ID: "+id);
        }
        Education existingEducation=isThereEducation.get();
        existingEducation.setCountry(updatedEducation.getCountry());
        existingEducation.setDepartment(updatedEducation.getDepartment());
        existingEducation.setTitle(updatedEducation.getTitle());
        existingEducation.setUniversity(updatedEducation.getUniversity());
        existingEducation.setEntryYear(updatedEducation.getEntryYear());
        existingEducation.setGraduationYear(updatedEducation.getGraduationYear());
        existingEducation.setEducationLevel(updatedEducation.getEducationLevel());
        educationRepository.save(existingEducation);
        return existingEducation;
    }

    @Override
    public void deleteEducationById(Integer id) {
    educationRepository.deleteById(id);
    }

}
