package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.StudentInfo;
import com.kara.studentscareer.bachelorpapel.repository.StudentInfoRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class StudentInfoServiceImpl implements StudentInfoService {

    private StudentInfoRepository studentRepository;

    @Override
    public StudentInfo createStudent(StudentInfo student) {
        return studentRepository.save(student);
    }

    @Override
    public List<StudentInfo> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<StudentInfo> findStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public StudentInfo updateStudent(Integer id, StudentInfo updatedStudent) {
        Optional<StudentInfo> isThereStudent=findStudentById(id);
        if(isThereStudent.isEmpty()){
            throw new EntityNotFoundException("There is no Student with this ID: "+id);
        }
        StudentInfo existingStudent=isThereStudent.get();
        existingStudent.setAm(updatedStudent.getAm());
        existingStudent.setEntryYear(updatedStudent.getEntryYear());
        existingStudent.setGraduationYear(updatedStudent.getGraduationYear());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudentById(Integer id) {
    studentRepository.deleteById(id);
    }

}
