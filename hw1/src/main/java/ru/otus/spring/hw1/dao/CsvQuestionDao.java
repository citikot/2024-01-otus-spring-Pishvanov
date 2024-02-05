package ru.otus.spring.hw1.dao;

import lombok.AllArgsConstructor;
import ru.otus.spring.hw1.config.TestFileNameProvider;
import ru.otus.spring.hw1.domain.Question;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {

        final String testQuestionsFileName = fileNameProvider.getTestFileName();

        // Использовать CsvToBean
        // https://opencsv.sourceforge.net/#collection_based_bean_fields_one_to_many_mappings
        // Использовать QuestionReadException

        return new ArrayList<>();
    }
}
