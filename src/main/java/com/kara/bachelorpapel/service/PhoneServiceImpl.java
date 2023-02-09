package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Phone;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;
    @Override
    public void addPhone(String number, User loggedInUser, String phoneType) {
       Phone newPhone=new Phone(number,loggedInUser,phoneType);
       phoneRepository.save(newPhone);
    }

    @Override
    @Transactional
    public void deletePhone(Integer phoneId) {
        phoneRepository.deleteById(phoneId);
    }
}
