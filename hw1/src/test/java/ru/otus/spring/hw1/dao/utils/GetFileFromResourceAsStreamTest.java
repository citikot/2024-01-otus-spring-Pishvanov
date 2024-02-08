package ru.otus.spring.hw1.dao.utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import ru.otus.spring.hw1.exceptions.QuestionReadException;

class GetFileFromResourceAsStreamTest {
    @Test
    void get_FileNotFound_ShouldThrowQuestionReadException() {
        // given
        String nonexistentFileName = "nonexistentFile.txt";

        // then
        assertThrows(QuestionReadException.class, () -> GetFileFromResourceAsStream.get(nonexistentFileName), "File name is incorrect");
    }
}
