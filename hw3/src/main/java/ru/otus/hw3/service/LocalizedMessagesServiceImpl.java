package ru.otus.hw3.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.hw3.config.LocaleConfig;

@RequiredArgsConstructor
@Service
public class LocalizedMessagesServiceImpl implements LocalizedMessagesService {

    private final LocaleConfig localeConfig;

    // Доделать
    @Override
    public String getMessage(String code, Object... args) {
        return null;
    }
}
