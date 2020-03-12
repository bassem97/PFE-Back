package com.ats.remotetimemanager.Repository;

import com.ats.remotetimemanager.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByPostName(String name);
}
