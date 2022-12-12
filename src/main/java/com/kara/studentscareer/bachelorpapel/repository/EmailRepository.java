package com.kara.studentscareer.bachelorpapel.repository;

import com.kara.studentscareer.bachelorpapel.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Integer> {
}
