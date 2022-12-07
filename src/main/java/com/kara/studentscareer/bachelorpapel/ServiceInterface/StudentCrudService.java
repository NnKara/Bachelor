package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.StudentInfo;

import java.util.List;
import java.util.Optional;

public interface StudentCrudService {

    StudentInfo createStudent(StudentInfo student);

    List<StudentInfo>findAllStudents();

    Optional<StudentInfo>findStudentById(Integer id);

    StudentInfo updateStudent(Integer id, StudentInfo student);

    void deleteStudentById(Integer id);
}
