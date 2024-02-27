package ru.otus.hw2.service;

import lombok.AllArgsConstructor;
import ru.otus.hw2.dao.QuestionDao;
import ru.otus.hw2.domain.Student;
import ru.otus.hw2.domain.TestResult;

@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (var question: questions) {
            var isAnswerValid = false; // Задать вопрос, получить ответ
            testResult.applyAnswer(question, isAnswerValid);
        }
        return testResult;
    }
}
