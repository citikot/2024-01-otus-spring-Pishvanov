package ru.otus.hw2.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw2.config.TestFileNameProvider;
import ru.otus.hw2.domain.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CsvQuestionDaoTest {

    @Mock
    private TestFileNameProvider fileNameProvider;

    @InjectMocks
    private CsvQuestionDao csvQuestionDao;

    @Test
    void findAll_ShouldReturnSizeOfListOfQuestions_WhenCsvFileIsReadSuccessfully() {
        // given
        int expectedSizeOfList = 9;
        when(fileNameProvider.getTestFileName()).thenReturn("questions.csv");

        // when
        List<Question> result = csvQuestionDao.findAll();

        // Assert
        assertEquals(expectedSizeOfList, result.size());
    }

    @Test
    void findAll_ShouldNotReturnSizeOfListOfQuestions_WhenCsvFileIsReadSuccessfully() {
        // given
        int notExpectedSizeOfList = 10;
        when(fileNameProvider.getTestFileName()).thenReturn("questions.csv");

        // when
        List<Question> result = csvQuestionDao.findAll();

        // Assert
        assertNotEquals(notExpectedSizeOfList, result.size());
    }
}