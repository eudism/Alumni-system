package com.finalproject.service;

import com.finalproject.entity.Address;

import java.util.Optional;

public interface AddressService {
    Optional<Address> getAddress();
}
