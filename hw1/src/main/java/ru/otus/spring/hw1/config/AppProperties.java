package ru.otus.spring.hw1.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AppProperties implements TestFileNameProvider {
    private String testFileName;

    @Override
    public String getTestFileName() {
        return testFileName;
    }

}


