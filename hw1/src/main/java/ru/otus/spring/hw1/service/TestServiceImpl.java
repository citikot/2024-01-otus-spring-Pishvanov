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

        // TODO may need to be sent to dedicated method after resolution of the main issue
        allTestData.forEach((e) -> ioService.printFormattedLine(e.text(), e.answers()));

    }

}
