package ru.otus.hw2.domain;

public record Student(String firstName, String lastName) {
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
