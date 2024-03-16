package ru.otus.hw2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw2.dao.QuestionDao;
import ru.otus.hw2.domain.Question;
import ru.otus.hw2.domain.Student;
import ru.otus.hw2.domain.TestResult;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private static final String ANSWER_PROMPT = "Please, enter the number of correct answer: ";

    private static final String ERROR_MESSAGE = "The number should be within the range. Please, try again.";

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        boolean isAnswerValid;
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (var question : questions) {
            isAnswerValid = processQuestionAndAnswers(question);
            testResult.applyAnswer(question, isAnswerValid);
        }

        return testResult;
    }

    boolean processQuestionAndAnswers(Question question) {
        int validAnswer = 0;
        ioService.printLine("");
        ioService.printLine(question.text());

        for (int i = 0; i < question.answers().size(); i++) {
            ioService.printLine("Answer " + (i + 1));
            ioService.printFormattedLine(question.answers().get(i).text());
            if (question.answers().get(i).isCorrect()) {
                validAnswer = i + 1;
            }
        }

        int receivedAnswer = ioService.readIntForRangeWithPrompt(1, question.answers().size(),
                                                                ANSWER_PROMPT, ERROR_MESSAGE);

        return validAnswer == receivedAnswer;

    }
}
