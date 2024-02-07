package ru.otus.spring.hw1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw1.service.TestRunnerService;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        var testRunnerService = context.getBean(TestRunnerService.class);
        testRunnerService.run();

    }
}