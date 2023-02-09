package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.User;

public interface ExperienceService {
    void addNewExperience(String company, String position, String startDate, String endDate, User loggedInUser);
    void deleteExperience(Integer id);

}
