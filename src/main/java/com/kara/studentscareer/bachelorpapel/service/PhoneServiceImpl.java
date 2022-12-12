package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Phone;
import com.kara.studentscareer.bachelorpapel.repository.PhoneRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneRepository phoneRepository;

    @Override
    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public List<Phone> findAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Optional<Phone> findPhoneById(Integer id) {
        return phoneRepository.findById(id);
    }

    @Override
    public Phone updatePhone(Integer id, Phone updatedPhone) {
        Optional<Phone> isTherePhone=findPhoneById(id);
        if(isTherePhone.isEmpty()){
            throw new EntityNotFoundException("There is no phone for this ID: "+id);
        }
        Phone existingPhone=isTherePhone.get();
        existingPhone.setNumber(updatedPhone.getNumber());
        existingPhone.setPhoneType(updatedPhone.getPhoneType());
        phoneRepository.save(existingPhone);
        return existingPhone;
    }

    @Override
    public void deletePhoneById(Integer id) {
        phoneRepository.deleteById(id);
    }
}
