package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Email;
import com.kara.bachelorpapel.entity.User;

import java.util.List;

public interface EmailService {


  void addEmailWithType(String newEmail, User loggedInUser, String emailType);

    void deleteByEmail(List<Email> email);
    void deleteEmail(Integer emailId);
}
