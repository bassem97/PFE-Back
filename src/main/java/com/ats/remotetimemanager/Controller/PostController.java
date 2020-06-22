package com.ats.remotetimemanager.Controller;

import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Model.WebSocketMessage;
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

    @Autowired
    WebSocketController webSocketController;

    @GetMapping("list")
    public List<Post> getAll() { return postService.findAll() ;}

    @PostMapping("add")
    public Post add(@RequestBody Post post) throws Exception {
        Post post3 = postService.add(post);
        webSocketController.sendMessage(new WebSocketMessage("post"));
        return post3;
    }

    @PutMapping("update")
    public Post update(@Valid @RequestBody Post post){ return postService.update(post);}

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        postService.delete(id);
        webSocketController.sendMessage(new WebSocketMessage("post"));
    }

    @GetMapping("findById/{id}")
    public Post findById(@PathVariable("id") Long id) {return postService.findById(id) ;}

    @GetMapping("findByPostName/{name}")
    public Post findByPostName(@PathVariable("name") String name) {return postService.findByPostName(name) ;}

}
