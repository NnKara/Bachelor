package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Phone;
import com.kara.bachelorpapel.entity.User;

public interface PhoneService {

    void addPhone(String phone, User loggedInUser, String phoneType);

    Phone getPhoneById(Integer id);
    Phone updatePhone(Phone phone);
    void deletePhone(Integer phoneId);
}
