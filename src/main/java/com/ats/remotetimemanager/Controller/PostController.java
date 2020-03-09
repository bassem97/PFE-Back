package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/post/")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("list")
    public List<Post> getAll() { return postService.findAll() ;}

    @PostMapping("add")
    public Post add(@RequestBody Post post) { return postService.add(post);}

    @PutMapping("update")
    public Post update(@Valid @RequestBody Post post){ return postService.update(post);}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) { postService.delete(id);}

    @GetMapping("findById/{id}")
    public Post findById(@PathVariable("id") Long id) {return postService.findById(id) ;}

}
