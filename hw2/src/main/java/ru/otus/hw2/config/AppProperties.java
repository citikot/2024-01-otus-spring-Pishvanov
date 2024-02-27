package ru.otus.hw2.config;

import lombok.Data;

@Data
public class AppProperties implements TestConfig, TestFileNameProvider {

    // внедрить свойство из application.properties
    private int rightAnswersCountToPass;

    // внедрить свойство из application.properties
    private String testFileName;

    @Override
    public String getTestFileName() {
        return testFileName;
    }

    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }
}
