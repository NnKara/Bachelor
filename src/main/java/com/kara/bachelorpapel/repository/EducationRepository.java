package com.kara.bachelorpapel.repository;

import com.kara.bachelorpapel.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education,Integer> {
}
