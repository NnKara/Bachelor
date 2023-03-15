package com.kara.bachelorpapel.repository;

import com.kara.bachelorpapel.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmailRepository extends JpaRepository<Email,Integer> {
// void deleteByEmail(List<Email> email);
}
