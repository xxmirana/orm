package com.education.platform.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TestDataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        // Инициализация тестовых данных
        // Будут добавлены демо-данные для тестирования
    }
}