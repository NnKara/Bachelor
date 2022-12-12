package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {

    Address createAddress(Address address);

    List<Address> findAllAddress();

    Optional<Address>findAddressById(Integer id);

    Address updateAddress(Address address,Integer id);

    void deleteAddressById(Integer id);





}
