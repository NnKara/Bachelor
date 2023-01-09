package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.User;

public interface ExperienceService {
    void addNewExperience(String company, String position, String startDate, String endDate, User loggedInUser);
    void deleteExperience(Integer id);

}
