package com.kara.bachelorpapel.service;

import com.kara.bachelorpapel.entity.User;

public interface AddressService {
    void saveNewAddress(String street, String number, String postalCode, String city, String country, User loggedInUser, String addressType);

   // Address updateAddress(String street, String number, String postalCode, String city, String country, User loggedInUser, String addressType);
    void deleteAddress(Integer addressId);
}
