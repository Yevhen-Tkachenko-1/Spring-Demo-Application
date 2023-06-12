package com.yevhent.springdemo.service;

public class OutputService {

    private final GreetingService greetingService;
    private final TimeService timeService;
    private final String name;
    private final String activeProfileName;

    public OutputService(GreetingService greetingService, TimeService timeService, String name, String activeProfileName) {
        this.greetingService = greetingService;
        this.timeService = timeService;
        this.name = name;
        this.activeProfileName = activeProfileName;
    }

    public void generateOutput() {
        String output = String.format("[%s] [%s] [%s]", timeService.getCurrentTime(), activeProfileName, greetingService.getGreeting(name));
        System.out.println(output);
    }
}
