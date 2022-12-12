package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.StudentInfo;

import java.util.List;
import java.util.Optional;

public interface StudentInfoService {

    StudentInfo createStudent(StudentInfo student);

    List<StudentInfo>findAllStudents();

    Optional<StudentInfo>findStudentById(Integer id);

    StudentInfo updateStudent(Integer id, StudentInfo student);

    void deleteStudentById(Integer id);
}
