package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.User;

public interface EmailService {


  void addEmailWithType(String newEmail, User loggedInUser,String emailType);

    void deleteEmail(Integer emailId);
}
