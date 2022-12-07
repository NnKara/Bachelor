package com.kara.studentscareer.bachelorpapel.Repository;

import com.kara.studentscareer.bachelorpapel.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String email);
}
