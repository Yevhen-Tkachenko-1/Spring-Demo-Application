package com.yevhent.springdemo.config;

import com.yevhent.springdemo.service.TimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.yevhent.springdemo")
public class ApplicationConfig {

    @Profile("dev")
    public TimeService timeService24(){
        System.out.println("TimeService24 Bean creation ...");
        return new TimeService(true);
    }

    @Bean
    @Profile("!dev")
    public TimeService timeService12(){
        System.out.println("TimeService12 Bean creation ...");
        return new TimeService(false);
    }
}
