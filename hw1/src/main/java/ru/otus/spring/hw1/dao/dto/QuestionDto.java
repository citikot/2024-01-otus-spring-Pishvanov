package ru.otus.spring.hw1.dao.dto;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import ru.otus.spring.hw1.domain.Answer;
import ru.otus.spring.hw1.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

    @CsvBindByPosition(position = 0, required = true)
    private String text;

    @CsvBindAndSplitByPosition(position = 1, elementType = Answer.class, collectionType = ArrayList.class,
            splitOn = "\\|", converter = AnswerCsvConverter.class)
    private List<Answer> answers;

    public Question toDomainObject() {
        return new Question(text, answers);
    }

}
