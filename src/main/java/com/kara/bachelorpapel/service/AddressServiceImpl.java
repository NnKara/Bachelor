package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.Address;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;


    @Override
    public void saveNewAddress(String street, String number, String postalCode, String city, String country, User loggedInUser, String addressType) {
        Address newAddress=new Address(street,number,postalCode,city,country,loggedInUser,addressType);
        addressRepository.save(newAddress);
    }

    @Override
    public void deleteAddress(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}
