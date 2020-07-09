package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Address;
import com.ats.remotetimemanager.Model.TempUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
