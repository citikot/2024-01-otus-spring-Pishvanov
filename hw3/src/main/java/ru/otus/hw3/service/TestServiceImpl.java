package ru.otus.hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw3.dao.QuestionDao;
import ru.otus.hw3.domain.Question;
import ru.otus.hw3.domain.Student;
import ru.otus.hw3.domain.TestResult;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private static final String ANSWER_PROMPT = "Please, enter the number of correct answer: ";

    private static final String ERROR_MESSAGE = "The number should be within the range. Please, try again.";

    private final LocalizedIOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printLineLocalized("TestService.answer.the.questions");
        ioService.printLine("");

        var questions = questionDao.findAll();
        var testResult = new TestResult(student);

        for (var question: questions) {
            var isAnswerValid = processQuestionAndAnswers(question);
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
