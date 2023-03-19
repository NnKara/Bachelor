package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Experience;
import com.kara.bachelorpapel.entity.User;

public interface ExperienceService {
    void addNewExperience(String company, String position, String startDate, String endDate, User loggedInUser);

    Experience getExById(Integer id);
    Experience updateExp(Experience experience);
    void deleteExperience(Integer id);

}
