package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    Image findByName (String name);
    Image findById(long Id);
}
