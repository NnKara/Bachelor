package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {

    Phone createPhone(Phone phone);

    List<Phone>findAllPhones();

    Optional<Phone>findPhoneById(Integer id);

    Phone updatePhone(Integer id,Phone phone);

    void deletePhoneById(Integer id);
}
