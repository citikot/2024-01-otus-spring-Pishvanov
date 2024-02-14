package ru.otus.spring.hw1.domain;

import java.util.List;

public record Question(String text, List<Answer> answers) {
}
