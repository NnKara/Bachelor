package com.kara.bachelorpapel.repository;

import com.kara.bachelorpapel.entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo,Integer> {

    StudentInfo getStudentInfoByAm(String am);
    void deleteStudentInfoByAm(String am);

}
