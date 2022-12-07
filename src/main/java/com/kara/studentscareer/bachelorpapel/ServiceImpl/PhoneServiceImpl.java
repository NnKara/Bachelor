package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.Phone;
import com.kara.studentscareer.bachelorpapel.Repository.PhoneRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.PhoneCrudService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class PhoneServiceImpl implements PhoneCrudService {

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
