package ru.otus.spring.hw1.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TestRunnerServiceImpl implements TestRunnerService {
    private final TestService testService;

    @Override
    public void run() {
        testService.executeTest();
    }
}
