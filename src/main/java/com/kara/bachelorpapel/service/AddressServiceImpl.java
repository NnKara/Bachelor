package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.converter.UserConverter;
import com.kara.bachelorpapel.entity.Address;
import com.kara.bachelorpapel.entity.User;
import com.kara.bachelorpapel.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserConverter converter;


    @Override
    public void saveNewAddress(String street, String number, String postalCode, String city, String country, User loggedInUser, String addressType) {
        Address newAddress=new Address(street,number,postalCode,city,country,loggedInUser,addressType);
        addressRepository.save(newAddress);
    }

    @Override
    public Address getAddressById(Integer id) {
        Optional<Address> optional = addressRepository.findById(id);
        Address address=null;
        if (optional.isPresent()) {
            address = optional.get();
        } else {
            throw new RuntimeException(" Address not found for id :: " + id);
        }
        return address;
    }

    @Override
    public Address updateAddress(Address address) {
      Address dbAddress=getAddressById(address.getAddressId());
       if(dbAddress==null){
            throw new EntityNotFoundException("This address doesn't exists!");
       } else if (address.getAddressType()!=null) {
           dbAddress.setAddressType(address.getAddressType());
       } else if (address.getStreet()!=null) {
           dbAddress.setStreet(address.getStreet());
       } else if (address.getNumber()!=null) {
           dbAddress.setNumber(address.getNumber());
       } else if (address.getCity()!=null) {
           dbAddress.setCity(address.getCity());
       } else if (address.getCountry()!=null) {
           dbAddress.setCountry(address.getCountry());
       }else if(address.getPostalCode()!=null) {
           dbAddress.setPostalCode(address.getPostalCode());
       }
       addressRepository.save(dbAddress);
       return dbAddress;
    }

    @Override
    public void deleteAddress(Integer addressId) {
        Optional<Address> dbAddress=addressRepository.findById(addressId);
        if(dbAddress.isEmpty()){
            throw new EntityNotFoundException("Address not found!");
        }else{
        addressRepository.deleteById(addressId);
    }
    }

}
