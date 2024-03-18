package ru.otus.hw3.dao;

import ru.otus.hw3.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
