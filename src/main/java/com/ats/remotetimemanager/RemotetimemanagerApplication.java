package com.ats.remotetimemanager;

import com.ats.remotetimemanager.Config.seeder.SeedByOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RemotetimemanagerApplication  {
    @Autowired
    private SeedByOrder seedByOrder;

    public static void main(String[] args) {
        SpringApplication.run(RemotetimemanagerApplication.class, args);
    }

    @PostConstruct
    public void init() throws Exception {
        seedByOrder.init();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer () {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*")
                        .allowedOrigins("*");
            }
        };
    }
}
