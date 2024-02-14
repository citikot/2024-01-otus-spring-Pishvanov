package ru.otus.spring.hw1.dao.helper;

import lombok.NoArgsConstructor;

import java.io.InputStream;

@NoArgsConstructor
public final class ResourceHelper {

    public static InputStream openResourceAsStream(String resourceName) {
        return ResourceHelper.class.getClassLoader().getResourceAsStream(resourceName);
    }
}
