package ru.otus.spring.hw1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.spring.hw1.dao.QuestionDao;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TestServiceImplTest {

    @Mock
    private IOService ioService;

    @Mock
    private QuestionDao dao;

    @InjectMocks
    private TestServiceImpl testService;

    @Test
    void testExecuteTestMethodWithNoException() {

        when(dao.findAll()).thenReturn(Arrays.asList());

        assertDoesNotThrow(() -> testService.executeTest());
    }
}