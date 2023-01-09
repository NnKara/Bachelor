package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Phone;
import com.kara.studentscareer.bachelorpapel.entity.User;
import com.kara.studentscareer.bachelorpapel.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService{

    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public void addPhone(String number, User loggedInUser, String phoneType) {
       Phone newPhone=new Phone(number,loggedInUser,phoneType);
       phoneRepository.save(newPhone);
    }

    @Override
    public void deletePhone(Integer id) {

    }
}
