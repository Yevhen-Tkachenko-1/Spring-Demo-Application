package com.yevhent.springdemo.config;

import com.yevhent.springdemo.service.GreetingService;
import com.yevhent.springdemo.service.OutputService;
import com.yevhent.springdemo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    @Value("true")
    private boolean is24;

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(greeting);
    }

    @Bean
    public TimeService timeService(){
        return new TimeService(is24);
    }

    @Bean
    public OutputService outputService(@Autowired GreetingService greetingService,
                                       @Autowired TimeService timeService){
        return new OutputService(greetingService, timeService, name);
    }
}
