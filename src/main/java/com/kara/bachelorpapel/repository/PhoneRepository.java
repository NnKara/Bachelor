package com.kara.bachelorpapel.repository;

import com.kara.bachelorpapel.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone,Integer> {
//    void deleteByNumber(String number);
}
