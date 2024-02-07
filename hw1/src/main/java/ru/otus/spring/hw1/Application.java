package ru.otus.spring.hw1;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw1.service.TestRunnerService;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws CsvValidationException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        var testRunnerService = context.getBean(TestRunnerService.class);
        testRunnerService.run();

    }
}