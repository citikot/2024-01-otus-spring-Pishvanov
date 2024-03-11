package ru.otus.hw2.dao.helper;

import java.io.InputStream;

@SuppressWarnings("java:S1118")
public final class ResourceHelper {

    public static InputStream openResourceAsStream(String resourceName) {
        return ResourceHelper.class.getClassLoader().getResourceAsStream(resourceName);
    }
}
