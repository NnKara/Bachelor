package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.User;

public interface PhoneService {

    void addPhone(String phone, User loggedInUser, String phoneType);

    void deletePhone(Integer phoneId);
}
