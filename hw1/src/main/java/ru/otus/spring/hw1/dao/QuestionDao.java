package ru.otus.spring.hw1.dao;

import ru.otus.spring.hw1.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
