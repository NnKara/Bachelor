package com.kara.studentscareer.bachelorpapel.ServiceInterface;

import com.kara.studentscareer.bachelorpapel.Entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressCrudService {

    Address createAddress(Address address);

    List<Address> findAllAddress();

    Optional<Address>findAddressById(Integer id);

    Address updateAddress(Address address,Integer id);

    void deleteAddressById(Integer id);





}
