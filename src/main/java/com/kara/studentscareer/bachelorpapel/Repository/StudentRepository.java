package com.kara.studentscareer.bachelorpapel.Repository;

import com.kara.studentscareer.bachelorpapel.Entity.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentInfo,Integer> {
}
