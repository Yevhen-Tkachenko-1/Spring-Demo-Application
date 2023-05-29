package com.yevhent.springdemo;

import com.yevhent.springdemo.service.GreetingService;
import com.yevhent.springdemo.service.OutputService;
import com.yevhent.springdemo.service.TimeService;

public class Application {

    public static void main(String[] args) throws Exception {
        GreetingService greetingService = new GreetingService("Hello");
        TimeService timeService = new TimeService(true);
        OutputService outputService = new OutputService(greetingService, timeService);

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput("Yevhen");
            Thread.sleep(5000);
        }
    }
}
