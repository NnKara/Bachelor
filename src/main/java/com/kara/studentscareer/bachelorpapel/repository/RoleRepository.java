package com.kara.studentscareer.bachelorpapel.repository;

import com.kara.studentscareer.bachelorpapel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
