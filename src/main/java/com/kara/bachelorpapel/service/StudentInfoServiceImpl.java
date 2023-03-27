package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.StudentInfo;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.StudentInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Override
    public void addStudentInfo(String am, String entryYear, String graduationYear, User loggedInUser) {
            StudentInfo newStudentInfo = new StudentInfo(am, entryYear, graduationYear, loggedInUser);
            studentInfoRepository.save(newStudentInfo);
        }

    @Override
    public StudentInfo getStInfoByAm(String am) {
        StudentInfo stInfo = studentInfoRepository.getStudentInfoByAm(am);
        if(stInfo!=null) {
            return stInfo;
        }else{
            throw new EntityNotFoundException(" Student-Info not found for am : " + am);
        }
    }

    @Override
    public StudentInfo updateStInfo(StudentInfo studentInfo) {
        StudentInfo dbStInfo=getStInfoByAm(studentInfo.getAm());
        if(dbStInfo==null){
            throw new EntityNotFoundException(" Student-Info not found for am : " + studentInfo.getAm());
        }
        if(studentInfo.getId()!=null){
            dbStInfo.setId(studentInfo.getId());
        }
        if(studentInfo.getEntryYear()!=null){
            dbStInfo.setEntryYear(studentInfo.getEntryYear());
        }
        if(studentInfo.getGraduationYear()!=null){
            dbStInfo.setGraduationYear(studentInfo.getGraduationYear());
        }
        studentInfoRepository.save(dbStInfo);
        return dbStInfo;
    }


    @Override
    @Transactional
    public void deleteStudentInfoByAM(String am) {
        studentInfoRepository.deleteStudentInfoByAm(am);
    }

}

