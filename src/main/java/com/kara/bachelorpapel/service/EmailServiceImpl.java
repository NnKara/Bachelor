package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Email;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.EmailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Email getEmailById(Integer id) {
        Optional<Email> optional = emailRepository.findById(id);
        Email email=null;
        if (optional.isPresent()) {
            email = optional.get();
        } else {
            throw new RuntimeException(" Email not found for id :: " + id);
        }
        return email;
    }

    @Override
    public Email updateEmail(Email email) {
       Email dbEmail=getEmailById(email.getEmailId());
        if(dbEmail==null){
            throw new EntityNotFoundException("This email doesn't exists!");
        }
        if(email.getUserEmail()!=null){
            dbEmail.setUserEmail(email.getUserEmail());
        }
        if(email.getEmailType()!=null){
            dbEmail.setEmailType(email.getEmailType());
        }
        emailRepository.save(dbEmail);
        return dbEmail;
    }


    @Override
    @Transactional
    public void deleteEmail(Integer emailId) {
        Email dbEmail=getEmailById(emailId);
        if(dbEmail==null){
            throw new EntityNotFoundException("Email not found!");
        }else{
            emailRepository.deleteById(emailId);
        }
    }
}
