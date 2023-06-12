package com.yevhent.springdemo.service;

public class GreetingService {

    private final String greeting;
    private final boolean isFormat;

    public GreetingService(String greeting, boolean isFormat) {
        this.greeting = greeting;
        this.isFormat = isFormat;
    }

    public String getGreeting(String name) {
        return isFormat ? String.format("\"%s %s!\"", greeting, name) : greeting + " " + name;
    }
}
