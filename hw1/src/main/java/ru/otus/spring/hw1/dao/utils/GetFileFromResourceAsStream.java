package ru.otus.spring.hw1.dao.utils;

import ru.otus.spring.hw1.exceptions.QuestionReadException;

import java.io.InputStream;

public class GetFileFromResourceAsStream {

    public static InputStream get(String fileName) {
        try {
            return GetFileFromResourceAsStream.class.getClassLoader().getResourceAsStream(fileName);
        } catch (RuntimeException e) {
            throw new QuestionReadException("File not found!", e);
        }
    }
}
