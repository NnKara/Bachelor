package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Email;

import java.util.List;
import java.util.Optional;

public interface EmailService {

    Email createEmail(Email email);

    List<Email>findAllEmails();

    Optional<Email>findEmailById(Integer id);

    Email updateEmail(Integer id,Email email);

    void deleteEmailById(Integer id);

}
