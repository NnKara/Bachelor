package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.StudentInfo;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.repository.StudentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl implements StudentInfoService{

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Override
    public void addStudentInfo(String am, String entryYear, String graduationYear, User loggedInUser) {
        StudentInfo newStudentInfo=new StudentInfo(am,entryYear,graduationYear,loggedInUser);
        studentInfoRepository.save(newStudentInfo);
    }

    @Override
    public void deleteStudentInfo() {

    }
}
