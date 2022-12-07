package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.Email;
import com.kara.studentscareer.bachelorpapel.Repository.EmailRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.EmailCrudService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class EmailServiceImpl implements EmailCrudService {

    private EmailRepository emailRepository;


    @Override
    public Email createEmail(Email email) {
        return emailRepository.save(email);
    }

    @Override
    public List<Email> findAllEmails() {
        return emailRepository.findAll();
    }

    @Override
    public Optional<Email> findEmailById(Integer id) {
        return emailRepository.findById(id);
    }

    @Override
    public Email updateEmail(Integer id, Email updatedEmail) {
        Optional<Email> isThereEmail=findEmailById(id);
        if(isThereEmail.isEmpty()){
            throw new EntityNotFoundException("There is no Email with this ID: "+id);
        }
        Email existingEmail=isThereEmail.get();
        existingEmail.setEmail(updatedEmail.getEmail());
        existingEmail.setEmailType(updatedEmail.getEmailType());
        emailRepository.save(existingEmail);
        return existingEmail;
    }

    @Override
    public void deleteEmailById(Integer id) {
        emailRepository.deleteById(id);
    }
}
