package com.kara.studentscareer.bachelorpapel.Repository;

import com.kara.studentscareer.bachelorpapel.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
}
