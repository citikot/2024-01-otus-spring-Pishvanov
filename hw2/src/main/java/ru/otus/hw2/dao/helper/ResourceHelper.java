package ru.otus.hw2.dao.helper;

import lombok.NoArgsConstructor;

import java.io.InputStream;

@NoArgsConstructor
public final class ResourceHelper {

    public static InputStream openResourceAsStream(String resourceName) {
        return ResourceHelper.class.getClassLoader().getResourceAsStream(resourceName);
    }
}
