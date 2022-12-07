package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.StudentInfo;
import com.kara.studentscareer.bachelorpapel.Repository.StudentRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.StudentCrudService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentCrudService {

    private StudentRepository studentRepository;

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
