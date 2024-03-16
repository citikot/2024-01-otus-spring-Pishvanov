package ru.otus.hw2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.otus.hw2.dao.QuestionDao;
import ru.otus.hw2.domain.Answer;
import ru.otus.hw2.domain.Question;
import ru.otus.hw2.domain.Student;
import ru.otus.hw2.domain.TestResult;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class TestServiceImplTest {

    @Mock
    private IOService ioService;

    @Mock
    private QuestionDao questionDao;

    @InjectMocks
    private TestServiceImpl testServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void processQuestionAndAnswers_ShouldReturnTrue_WhenValidAnswerIsProvided() {
        // given
        Question question = new Question("Question text",
                Arrays.asList(
                        new Answer("Answer 1", false),
                        new Answer("Answer 2", true),
                        new Answer("Answer 3", false)
                )
        );

        when(ioService.readIntForRangeWithPrompt(anyInt(), anyInt(), anyString(), anyString())).thenReturn(2);

        // when
        boolean result = testServiceImpl.processQuestionAndAnswers(question);

        // then
        assertTrue(result);
        verify(ioService, times(1)).readIntForRangeWithPrompt(anyInt(), anyInt(), anyString(), anyString());
    }

    @Test
    void processQuestionAndAnswers_ShouldReturnFalse_WhenInvalidAnswerIsProvided() {
        // given
        Question question = new Question("Question text",
                Arrays.asList(
                        new Answer("Answer 1", false),
                        new Answer("Answer 2", true),
                        new Answer("Answer 3", false)
                )
        );

        when(ioService.readIntForRangeWithPrompt(anyInt(), anyInt(), anyString(), anyString())).thenReturn(1);

        // when
        boolean result = testServiceImpl.processQuestionAndAnswers(question);

        // then
        assertFalse(result);
    }

    @Test
    void executeTestFor_ShouldReturnTestResultWithCorrectAnswers() {
        // given
        int rightAnswersCount = 2;
        int answeredQuestionListSize = 2;
        Student student = new Student("Basil", "Pupkins");
        List<Question> testQuestions = Arrays.asList(
                new Question("Question 1", Arrays.asList(new Answer("A1", true), new Answer("A2", false))),
                new Question("Question 2", Arrays.asList(new Answer("B1", false), new Answer("B2", true)))
        );

        when(questionDao.findAll()).thenReturn(testQuestions);
        when(ioService.readIntForRangeWithPrompt(anyInt(), anyInt(), anyString(), anyString()))
                .thenReturn(1, 2);

        // when
        TestResult result = testServiceImpl.executeTestFor(student);

        // then
        assertAll (
                () -> assertEquals(student, result.getStudent()),
                () -> assertEquals(answeredQuestionListSize, result.getAnsweredQuestions().size()),
                () -> assertEquals(rightAnswersCount, result.getRightAnswersCount())
        );
    }

}