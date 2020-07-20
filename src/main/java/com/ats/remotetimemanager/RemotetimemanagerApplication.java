package com.ats.remotetimemanager;

import com.ats.remotetimemanager.Config.seeder.RoleSeeder;
import com.ats.remotetimemanager.Config.seeder.SeedByOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class RemotetimemanagerApplication  {
    @Autowired
    private SeedByOrder seedByOrder;

    @Autowired
    RoleSeeder roleSeeder;

    public static void main(String[] args) {
        SpringApplication.run(RemotetimemanagerApplication.class, args);
    }

    @PostConstruct
    public void init() throws Exception {

        // Don't Comment !!!!!!!!!!!!!
//            roleSeeder.seed();
        // Don't Comment !!!!!!!!!!!!!

//        seedByOrder.init();
    }

    @Configuration
    @Profile("local")
    @ComponentScan(lazyInit = true)
    static class loadConfig{

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
