package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.User;

public interface EducationService {
    void addNewEducation(String entryYear, String graduationYear, String university, String department, User loggedInUser, String educationLevel, String title, String country);
    void deleteEducation(Integer id);
}
