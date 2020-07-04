package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostSeeder {

    @Autowired
    private PostRepository postRepository ;
    Post designer = new Post("Web developer");
    Post tester = new Post("Tester");
    Post web_developer = new Post("Designer");
    Post chef_department = new Post("CHEF_DEPARTMENT");
    public  void seed(){

        if(postRepository.findAll().isEmpty()){
            postRepository.save(tester);
            postRepository.save(designer);
            postRepository.save(web_developer);
            postRepository.save(chef_department);
        }
    }

}
