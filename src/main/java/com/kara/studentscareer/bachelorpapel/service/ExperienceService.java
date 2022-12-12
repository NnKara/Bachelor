package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {

    Experience createExperience(Experience experience);

    List<Experience>findAllExperiences();

    Optional<Experience>findExperienceById(Integer id);

    Experience updateExperience(Integer id,Experience experience);

    void deleteExperienceById(Integer id);
}
