package ru.otus.hw3.service;

public interface LocalizedMessagesService {
    String getMessage(String code, Object ...args);
}
