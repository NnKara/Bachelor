package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.Email;

import java.util.List;
import java.util.Optional;

public interface EmailCrudService {

    Email createEmail(Email email);

    List<Email>findAllEmails();

    Optional<Email>findEmailById(Integer id);

    Email updateEmail(Integer id,Email email);

    void deleteEmailById(Integer id);

}
