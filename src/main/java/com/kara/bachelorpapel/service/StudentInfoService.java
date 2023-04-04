package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.StudentInfo;
import com.kara.bachelorpapel.entity.User;

import java.util.List;

public interface StudentInfoService {
    void addStudentInfo(String am, String entryYear, String graduationYear, User loggedInUser);

    StudentInfo getStInfoById(Integer id);
    List<StudentInfo> getAllStInfo();
    StudentInfo updateStInfo(StudentInfo studentInfo);
    void deleteStInfo(User loggedInUser,Integer id);

}
