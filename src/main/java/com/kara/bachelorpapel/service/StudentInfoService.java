package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.StudentInfo;
import com.kara.bachelorpapel.entity.User;

public interface StudentInfoService {
    void addStudentInfo(String am, String entryYear, String graduationYear, User loggedInUser);

    StudentInfo getStInfoByAm(String am);
    StudentInfo updateStInfo(StudentInfo studentInfo);
    void deleteStudentInfoByAM(String am);

}
