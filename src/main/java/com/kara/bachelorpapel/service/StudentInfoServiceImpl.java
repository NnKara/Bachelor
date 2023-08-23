package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.StudentInfo;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.StudentInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    @Override
    public void addStudentInfo(String am, String entryYear, String graduationYear, User loggedInUser) {
        if(isThereStINFO(loggedInUser)) {
            StudentInfo newStudentInfo = new StudentInfo(am, entryYear, graduationYear, loggedInUser);
            studentInfoRepository.save(newStudentInfo);
        }else{
            throw new RuntimeException("Student Info Already Exists!");
        }
        }

    @Override
    public StudentInfo getStInfoById(Integer id) {
        StudentInfo stInfo = studentInfoRepository.getReferenceById(id);
        if(stInfo!=null) {
            return stInfo;
        }else{
            throw new EntityNotFoundException(" Student-Info not found for id : " + id);
        }
    }

    public boolean isThereStINFO(User loggedInUser){
        if(loggedInUser.getStudentInfo()!=null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<StudentInfo> getAllStInfo() {
        return studentInfoRepository.findAll();
    }

    @Override
    public StudentInfo updateStInfo(StudentInfo studentInfo) {
        StudentInfo dbStInfo=getStInfoById(studentInfo.getStudentInfoId());
        if(dbStInfo==null){
            throw new EntityNotFoundException(" Student-Info not found for id : " + studentInfo.getStudentInfoId());
        }
        if(studentInfo.getAm()!=null){
            dbStInfo.setAm(studentInfo.getAm());
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
    public void deleteStInfo(User loggedInUser,Integer id) {
        StudentInfo loggedInUsersStInfo=getStInfoById(id);
        if(loggedInUsersStInfo!=null){
            studentInfoRepository.delete(loggedInUsersStInfo);
        }else {
            throw new EntityNotFoundException("Student-Info doesn't exists!");
        }
    }
}

