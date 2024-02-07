package ru.otus.spring.hw1.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import ru.otus.spring.hw1.config.TestFileNameProvider;
import ru.otus.spring.hw1.dao.dto.QuestionDto;
import ru.otus.spring.hw1.dao.utils.GetFileFromResourceAsStream;
import ru.otus.spring.hw1.domain.Question;
import ru.otus.spring.hw1.exceptions.QuestionReadException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CsvQuestionDao implements QuestionDao {

    // Использовать CsvToBean - DONE
    // https://opencsv.sourceforge.net/#collection_based_bean_fields_one_to_many_mappings
    // Использовать QuestionReadException - DONE

    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {

        final String testQuestionsFileName = fileNameProvider.getTestFileName();

        List<Question> questionList = new ArrayList<>();

        InputStream is = GetFileFromResourceAsStream.get(testQuestionsFileName);

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build()) {
            List<QuestionDto> questionDtoList = new CsvToBeanBuilder<QuestionDto>(csvReader)
                    .withType(QuestionDto.class)
                    .build()
                    .parse();

            // TODO remove after debug
            questionDtoList.forEach(System.out::println);

            questionDtoList.forEach((e) -> questionList.add(e.toDomainObject()));
        } catch (RuntimeException | IOException e) {
            throw new QuestionReadException("CSV processing error", e);
        }
        return questionList;
    }
}
