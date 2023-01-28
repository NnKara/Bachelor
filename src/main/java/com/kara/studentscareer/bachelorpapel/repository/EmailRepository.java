package com.kara.studentscareer.bachelorpapel.repository;

import com.kara.studentscareer.bachelorpapel.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<Email,Integer> {
//    void deleteByEmail(String email);
}
