package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Education;
import com.kara.bachelorpapel.entity.User;

public interface EducationService {
    void addNewEducation(String entryYear, String graduationYear, String university, String department, User loggedInUser, String educationLevel, String title, String country);

    Education getEducationById(Integer id);
    Education updateEducation(Education education);
    void deleteEducation(Integer id);
}
