package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Email;
import com.kara.bachelorpapel.entity.User;

public interface EmailService {


  void addEmailWithType(String newEmail, User loggedInUser, String emailType);

  Email getEmailById(Integer id);
  Email updateEmail(Email email);
    void deleteEmail(Integer emailId);
}
