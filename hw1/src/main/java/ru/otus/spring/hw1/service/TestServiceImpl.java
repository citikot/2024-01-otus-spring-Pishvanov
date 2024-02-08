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

        allTestData.forEach(this::printQuestionAndAnswers);

    }

    private void printQuestionAndAnswers (Question question) {
        final int[] counter = {1};
        ioService.printLine("");
        ioService.printLine(question.text());
        question.answers().forEach((e) -> {
            ioService.printLine("Answer " + String.valueOf(counter[0]));
            ioService.printFormattedLine(e.text());
            ioService.printLine("Is it correct? " + String.valueOf(e.isCorrect()));
            counter[0]++;
        });
    }

}
