package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Phone;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Phone getPhoneById(Integer id) {
        Optional<Phone> optional = phoneRepository.findById(id);
        Phone phone=null;
        if (optional.isPresent()) {
            phone = optional.get();
        } else {
            throw new RuntimeException(" Phone not found for id :: " + id);
        }
        return phone;
    }

    @Override
    public Phone updatePhone(Phone phone) {
        Phone dbPhone=getPhoneById(phone.getPhoneId());
        if(dbPhone==null){
            throw new EntityNotFoundException(" Phone not found for id :: " + phone.getPhoneId());
        }
        if(phone.getPhoneType()!=null){
            dbPhone.setPhoneType(phone.getPhoneType());
        }
        if(phone.getNumber()!=null){
            dbPhone.setNumber(phone.getNumber());
        }
        phoneRepository.save(dbPhone);
        return dbPhone;

    }


    @Override
    @Transactional
    public void deletePhone(Integer phoneId) {
        phoneRepository.deleteById(phoneId);
    }
}
