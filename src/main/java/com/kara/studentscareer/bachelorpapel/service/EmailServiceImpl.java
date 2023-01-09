package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Email;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;





//    @Override
//    public Email save(String email,EmailType emailType) {
//       Email newEmail= emailConverter.stringToEmail(email);
//        emailRepository.save(newEmail,emailType);
//        return newEmail;
//    }

    @Override
    public void addEmailWithType(String controllerEmail, User loggedInUser,String emailType) {
        Email newEmail=new Email(controllerEmail,loggedInUser, emailType);
        emailRepository.save(newEmail);
    }


    @Override
    public void deleteEmail(String email) {
        Email usersEmail=emailRepository.findByEmail(email);
        emailRepository.delete(usersEmail);
    }
}
