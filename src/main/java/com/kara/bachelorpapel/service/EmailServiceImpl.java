package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Email;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;


    @Override
    public void addEmailWithType(String controllerEmail, User loggedInUser, String emailType) {
        Email newEmail=new Email(controllerEmail,loggedInUser, emailType);
        emailRepository.save(newEmail);
    }

    @Override
    @Transactional
    public void deleteEmail(Integer emailId) {
        emailRepository.deleteById(emailId);
    }
}
