package ru.otus.hw2.dao;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import ru.otus.hw2.config.TestFileNameProvider;
import ru.otus.hw2.dao.dto.QuestionDto;
import ru.otus.hw2.dao.helper.ResourceHelper;
import ru.otus.hw2.domain.Question;
import ru.otus.hw2.exceptions.QuestionReadException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {
        // Использовать CsvToBean
        // https://opencsv.sourceforge.net/#collection_based_bean_fields_one_to_many_mappings
        // Использовать QuestionReadException
        // Про ресурсы: https://mkyong.com/java/java-read-a-file-from-resources-folder/
        final String testQuestionsFileName = fileNameProvider.getTestFileName();

        List<Question> questionList;

        InputStream is = ResourceHelper.openResourceAsStream(testQuestionsFileName);

        try (CSVReader csvReader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build()) {
            List<QuestionDto> questionDtoList = new CsvToBeanBuilder<QuestionDto>(csvReader)
                    .withType(QuestionDto.class)
                    .build()
                    .parse();
            questionList = questionDtoList.stream().map(QuestionDto::toDomainObject).collect(Collectors.toList());
        } catch (RuntimeException | IOException e) {
            throw new QuestionReadException("CSV file processing error or file not found!", e);
        }
        return questionList;
    }
}
