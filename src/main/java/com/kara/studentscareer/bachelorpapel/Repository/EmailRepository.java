package com.kara.studentscareer.bachelorpapel.Repository;

import com.kara.studentscareer.bachelorpapel.Entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Integer> {
}
