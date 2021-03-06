package com.ats.remotetimemanager.Service.Post;

import com.ats.remotetimemanager.Model.Post;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {
    Post add(Post post);
    Post update(Post post, Long id );
    void delete(long id);
    List<Post> findAll();
    Post findById(Long id);
    Post findByPostName(String name);
}
