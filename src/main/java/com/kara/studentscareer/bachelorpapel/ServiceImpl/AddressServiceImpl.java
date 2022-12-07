package com.kara.studentscareer.bachelorpapel.ServiceImpl;

import com.kara.studentscareer.bachelorpapel.Entity.Address;
import com.kara.studentscareer.bachelorpapel.Repository.AddressRepository;
import com.kara.studentscareer.bachelorpapel.ServiceInterface.AddressCrudService;
import com.kara.studentscareer.bachelorpapel.UtilClassCalculations.Calculations;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressCrudService {

    private AddressRepository addressRepository;

    private Calculations calculations;

    @Override
    public Address createAddress(Address address) {

        return addressRepository.save(address);
    }

    @Override
    public List<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findAddressById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address updateAddress(Address updatedAddress, Integer id) {
        Optional<Address> isThereAddress = addressRepository.findById(id);
        if (isThereAddress.isEmpty()) {
            throw new EntityNotFoundException("There is no Address with this ID: " + id);
        }
        Address existingAddress=isThereAddress.get();
        existingAddress.setCity(updatedAddress.getCity());
        existingAddress.setNumber(updatedAddress.getNumber());
        existingAddress.setCountry(updatedAddress.getCountry());
        existingAddress.setPostalCode(updatedAddress.getPostalCode());
        existingAddress.setAddressType(updatedAddress.getAddressType());
        addressRepository.save(existingAddress);
        return existingAddress;
    }


    @Override
    public void deleteAddressById(Integer id) {
        addressRepository.deleteById(id);
    }
}
