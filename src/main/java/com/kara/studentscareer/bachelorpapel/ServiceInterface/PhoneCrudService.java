package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneCrudService {

    Phone createPhone(Phone phone);

    List<Phone>findAllPhones();

    Optional<Phone>findPhoneById(Integer id);

    Phone updatePhone(Integer id,Phone phone);

    void deletePhoneById(Integer id);
}
