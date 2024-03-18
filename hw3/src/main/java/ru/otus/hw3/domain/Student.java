package ru.otus.hw3.domain;

public record Student(String firstName, String lastName) {
    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
