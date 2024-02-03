package ru.otus.spring.hw1.service;

public interface IOService {
    void printLine(String s);

    void printFormattedLine(String s, Object ...args);
}
