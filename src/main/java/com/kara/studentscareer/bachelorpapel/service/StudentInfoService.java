package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.User;

public interface StudentInfoService {
    void addStudentInfo(String am, String entryYear, String graduationYear, User loggedInUser);
    void deleteStudentInfoByAM(String am);

//    boolean studentInfoExists(String am , User user);
}
