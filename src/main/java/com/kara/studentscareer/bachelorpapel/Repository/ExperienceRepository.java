package com.kara.studentscareer.bachelorpapel.Repository;

import com.kara.studentscareer.bachelorpapel.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Integer> {
}
