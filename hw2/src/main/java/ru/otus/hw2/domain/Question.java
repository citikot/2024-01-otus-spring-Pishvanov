package ru.otus.hw2.domain;

import java.util.List;

public record Question(String text, List<Answer> answers) {
}
