package com.yevhent.springdemo.config;

import com.yevhent.springdemo.service.GreetingService;
import com.yevhent.springdemo.service.OutputService;
import com.yevhent.springdemo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    @Bean
    public GreetingService greetingService(){
        return new GreetingService(greeting);
    }

    @Bean
    @Profile("dev")
    public TimeService timeService24(){
        return new TimeService(true);
    }

    @Bean
    @Profile("!dev")
    public TimeService timeService12(){
        return new TimeService(false);
    }

    @Bean
    public OutputService outputService(@Autowired GreetingService greetingService,
                                       @Autowired TimeService timeService){
        return new OutputService(greetingService, timeService, name);
    }
}
