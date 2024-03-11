package ru.otus.hw2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw2.domain.Student;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final IOService ioService;

    @Override
    public Student determineCurrentStudent() {
        var firstName = ioService.readStringWithPrompt("Please input your first name");
        var lastName = ioService.readStringWithPrompt("Please input your last name");
        return new Student(firstName, lastName);
    }
}
