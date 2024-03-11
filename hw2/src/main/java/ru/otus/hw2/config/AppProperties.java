package ru.otus.hw2.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.hw2.service.IOService;
import ru.otus.hw2.service.StreamsIOService;

@Data
@Configuration
public class AppProperties implements TestConfig, TestFileNameProvider {

    @Value("${test.rightAnswersCountToPass}")
    private int rightAnswersCountToPass;

    @Value("${test.fileName}")
    private String testFileName;

    @Bean
    public IOService ioService() {
        return new StreamsIOService(System.out, System.in);
    }

    @Override
    public String getTestFileName() {
        return testFileName;
    }

    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }
}
