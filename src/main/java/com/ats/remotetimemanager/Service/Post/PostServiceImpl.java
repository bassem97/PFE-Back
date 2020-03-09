package com.ats.remotetimemanager.Service.Post;

import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "postService")
public class PostServiceImpl implements PostService{
    
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        List<Post> list = new ArrayList<>();
        postRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Post add(Post post) {
//        if(postRepository.findById(Post.getAddressId()).isPresent()) {
//            Post.setPassword(passwordEncoder.encode(Post.getPassword()));
        return postRepository.save(post);
//        }else return null;
    }

    @Override
    public Post update(Post post) { return postRepository.save(post); }

    @Override
    public void delete(long id) { postRepository.deleteById(id);}

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).isPresent()?
                postRepository.findById(id).get() : null;
    }
}
