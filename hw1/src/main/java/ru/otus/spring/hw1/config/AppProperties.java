package ru.otus.spring.hw1.config;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
public class AppProperties implements TestFileNameProvider {
    private String testFileName;

    @Override
    public String getTestFileName() {
        return testFileName;
    }

}


