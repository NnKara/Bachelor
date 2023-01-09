package com.kara.studentscareer.bachelorpapel.service;

import com.kara.studentscareer.bachelorpapel.entity.User;

public interface AddressService {
    void saveNewAddress(String street, String number, String postalCode, String city, String country, User loggedInUser, String addressType);
    void deleteAddress(Integer id);
}
