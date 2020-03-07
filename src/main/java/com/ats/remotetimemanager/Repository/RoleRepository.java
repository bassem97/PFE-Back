package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {
}
