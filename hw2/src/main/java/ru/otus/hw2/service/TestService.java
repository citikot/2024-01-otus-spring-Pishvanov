package ru.otus.hw2.service;

import ru.otus.hw2.domain.Student;
import ru.otus.hw2.domain.TestResult;

public interface TestService {
    TestResult executeTestFor(Student student);
}
