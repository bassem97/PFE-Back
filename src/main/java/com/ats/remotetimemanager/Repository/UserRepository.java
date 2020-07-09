package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Department;
import com.ats.remotetimemanager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findByCin(String cin);
    User findByUserId(long id);
    List<User> findAllByDepartment(Department department);
}