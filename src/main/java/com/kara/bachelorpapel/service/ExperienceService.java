package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Experience;
import com.kara.bachelorpapel.entity.User;

import java.util.List;

public interface ExperienceService {
    void addNewExperience(String company, String position, String startDate, String endDate, User loggedInUser);

    Experience getExById(Integer id);
    List<Experience> getAllExp();
    Experience updateExp(Experience experience);

    void deleteExperience(Integer id);

}
