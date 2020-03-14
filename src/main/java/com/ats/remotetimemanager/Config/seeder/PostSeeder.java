package com.ats.remotetimemanager.Config.seeder;

import com.ats.remotetimemanager.Model.Post;
import com.ats.remotetimemanager.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostSeeder {

    @Autowired
    private PostRepository postRepository ;
    Post employer = new Post("EMPLOYER");
    Post employee = new Post("EMPLOYEE");
    Post chef_department = new Post("CHEF_DEPARTMENT");
    public  void seed(){

        if(postRepository.findAll().isEmpty()){
            System.out.println(employer);
            System.out.println(employee);
            System.out.println(chef_department);
            postRepository.save(employee);
            postRepository.save(employer);
            postRepository.save(chef_department);
        }
    }
}
