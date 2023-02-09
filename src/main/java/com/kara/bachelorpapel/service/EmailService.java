package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.User;

public interface EmailService {


  void addEmailWithType(String newEmail, User loggedInUser, String emailType);

//  Address updateAddress(String updatedEmail,User loggedInUser,String emailType);
    void deleteEmail(Integer emailId);
}
