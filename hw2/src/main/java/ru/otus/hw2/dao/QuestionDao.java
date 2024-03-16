package ru.otus.hw2.dao;

import ru.otus.hw2.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
