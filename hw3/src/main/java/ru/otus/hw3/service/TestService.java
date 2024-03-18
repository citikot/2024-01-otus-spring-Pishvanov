package ru.otus.hw3.service;

import ru.otus.hw3.domain.Student;
import ru.otus.hw3.domain.TestResult;

public interface TestService {
    TestResult executeTestFor(Student student);
}
