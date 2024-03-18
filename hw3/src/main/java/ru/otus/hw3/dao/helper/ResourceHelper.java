package ru.otus.hw3.dao.helper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResourceHelper {

    public static InputStream openResourceAsStream(String resourceName) {
        return ResourceHelper.class.getClassLoader().getResourceAsStream(resourceName);
    }
}
