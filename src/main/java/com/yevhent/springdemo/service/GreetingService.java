package com.yevhent.springdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Value("${app.greeting}")
    private String greeting;
    @Value("#{environment['spring.profiles.active'] == 'prod'}")
    private boolean isFormat;

    public GreetingService() {
        System.out.println("GreetingService creation ...");
    }

    public String getGreeting(String name) {
        return isFormat ? String.format("\"%s %s!\"", greeting, name) : greeting + " " + name;
    }
}
