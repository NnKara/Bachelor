package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceCrudService {

    Experience createExperience(Experience experience);

    List<Experience>findAllExperiences();

    Optional<Experience>findExperienceById(Integer id);

    Experience updateExperience(Integer id,Experience experience);

    void deleteExperienceById(Integer id);
}
