package ru.otus.spring.hw1.service;

import lombok.RequiredArgsConstructor;
import ru.otus.spring.hw1.dao.QuestionDao;
import ru.otus.spring.hw1.domain.Answer;
import ru.otus.spring.hw1.domain.Question;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ListIterator;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao dao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below:%n");

        List<Question> allTestData = dao.findAll();
        allTestData.forEach(this::printQuestionAndAnswers);

    }

    private void printQuestionAndAnswers (Question question) {
        ioService.printLine("");
        ioService.printLine(question.text());

        for (int i = 0; i < question.answers().size(); i++) {
            ioService.printLine("Answer " + (i + 1));
            ioService.printFormattedLine(question.answers().get(i).text());
            ioService.printLine("Is it correct? " + question.answers().get(i).isCorrect());
        }
    }

}
