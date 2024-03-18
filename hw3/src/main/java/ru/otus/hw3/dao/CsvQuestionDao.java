package ru.otus.hw3.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.hw3.config.TestFileNameProvider;
import ru.otus.hw3.dao.dto.QuestionDto;
import ru.otus.hw3.dao.helper.ResourceHelper;
import ru.otus.hw3.domain.Question;
import ru.otus.hw3.exceptions.QuestionReadException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RequiredArgsConstructor
@Component
public class CsvQuestionDao implements QuestionDao {

    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {

        final String testQuestionsFileName = fileNameProvider.getTestFileName();
        List<Question> questionList;

        InputStream is = ResourceHelper.openResourceAsStream(testQuestionsFileName);

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build()) {
            List<QuestionDto> questionDtoList = new CsvToBeanBuilder<QuestionDto>(csvReader)
                    .withType(QuestionDto.class)
                    .build()
                    .parse();
            questionList = questionDtoList.stream().map(QuestionDto::toDomainObject).toList();
        } catch (RuntimeException | IOException e) {
            throw new QuestionReadException("CSV file processing error or file not found!", e);
        }
        return questionList;
    }
}
