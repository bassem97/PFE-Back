package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepName(String name);
    Department findById(long depId);

}
