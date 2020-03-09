package com.ats.remotetimemanager.Service.Address;

import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> findAll() {
        List<Address> list = new ArrayList<>();
        addressRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Address add(Address Address) {
//        if(AddressRepository.findById(Address.getAddressId()).isPresent()) {
//            Address.setPassword(passwordEncoder.encode(Address.getPassword()));
            return addressRepository.save(Address);
//        }else return null;
    }

    @Override
    public Address update(Address Address) {
        return addressRepository.save(Address);
    }

    @Override
    public void delete(long id) { addressRepository.deleteById(id);}


    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).isPresent()?
                addressRepository.findById(id).get() : null;
    }
}
