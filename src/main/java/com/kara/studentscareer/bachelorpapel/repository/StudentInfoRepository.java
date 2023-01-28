package com.kara.studentscareer.bachelorpapel.repository;

import com.kara.studentscareer.bachelorpapel.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo,Integer> {
    void deleteStudentInfoByAm(String am);
}
