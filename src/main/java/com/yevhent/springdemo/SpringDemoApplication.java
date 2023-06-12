package com.yevhent.springdemo;

import com.yevhent.springdemo.config.ApplicationConfig;
import com.yevhent.springdemo.service.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDemoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
