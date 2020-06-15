package com.ats.remotetimemanager;

import com.ats.remotetimemanager.Config.seeder.SeedByOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RemotetimemanagerApplication  {
    @Autowired
    private SeedByOrder seedByOrder;

//    @Autowired
//    private ObjectMapper objectMapper;


    public static void main(String[] args) {
        SpringApplication.run(RemotetimemanagerApplication.class, args);
    }

    @PostConstruct
    public void init() {
        seedByOrder.init();
    }

//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        MappingJackson2HttpMessageConverter converter =
//                new MappingJackson2HttpMessageConverter(mapper);
//        return converter;
//    }

//    @PostConstruct
//    public void setUp() {
//        objectMapper.registerModule(new JavaTimeModule());
//    }


}
