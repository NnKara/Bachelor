package com.kara.bachelorpapel.repository;

import com.kara.bachelorpapel.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
//    void deleteByCountry(String country);
}
