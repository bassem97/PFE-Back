package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Service.Address.AddressService;
import com.ats.remotetimemanager.Service.Address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/address/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("list")
    public List<Address> getAll() { return addressService.findAll() ;}

    @PostMapping("add")
    public Address add(@RequestBody Address address) {
        return addressService.add(address);}

    @PutMapping("update/{id}")
    public Address update(@Valid @RequestBody Address address,  @PathVariable("id") Long id){
        return addressService.update(address,id);}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) { addressService.delete(id);}

    @GetMapping("findById/{id}")
    public Address findById(@PathVariable("id") Long id) {return addressService.findById(id) ;}

}
