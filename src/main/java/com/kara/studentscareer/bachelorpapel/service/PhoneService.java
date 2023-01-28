package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.User;

public interface PhoneService {

    void addPhone(String phone, User loggedInUser,String phoneType);

    void deletePhone(Integer phoneId);
}
