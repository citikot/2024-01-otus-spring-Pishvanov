package ru.otus.spring.hw1.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.spring.hw1.dao.QuestionDao;
import ru.otus.spring.hw1.domain.Question;

import java.util.List;

@NoArgsConstructor
@Data
public class TestServiceImpl implements TestService {

    private IOService ioService;

    private QuestionDao dao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below:%n");

        List<Question> allTestData = dao.findAll();
        printAllTestData(allTestData);

    }

    // TODO refactor after main issue resolving
    public void printAllTestData(List<Question> testData) {
        testData.forEach((e) -> ioService.printFormattedLine(e.text(), e.answers()));
    }

}
