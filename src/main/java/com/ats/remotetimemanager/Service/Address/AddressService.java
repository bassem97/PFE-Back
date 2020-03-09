package com.ats.remotetimemanager.Service.Address;

import com.ats.remotetimemanager.Model.Address;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AddressService {
    Address add(Address address);
    Address update(Address address);
    void delete(long id);
    List<Address> findAll();
    Address findById(Long id);
}
