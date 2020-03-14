package com.ats.remotetimemanager;

import com.ats.remotetimemanager.Config.seeder.SeedByOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RemotetimemanagerApplication  {
    @Autowired
    private SeedByOrder seedByOrder;

    public static void main(String[] args) { 
        SpringApplication.run(RemotetimemanagerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        seedByOrder.init();
    }
}
