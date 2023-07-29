package ru.rail.services;

import ru.rail.dao.WordsPairDao;
import ru.rail.dto.WordsPairDto;

import java.util.Optional;

public class WordService {

    private final WordsPairDao wordsPairDao = new WordsPairDao();

    public Optional<WordsPairDto> getRussianTranslation(String englishWord) {
        return wordsPairDao.getRussianByEnglish(englishWord)
                .map(wordsPair -> new WordsPairDto(wordsPair.getRussianWord(),
                        wordsPair.getEnglishWord()));
    }

    public Optional<WordsPairDto> getEnglishTranslation(String russianWord) {
        return wordsPairDao.getEnglishByRussian(russianWord)
                .map(wordsPair -> new WordsPairDto(wordsPair.getEnglishWord(),
                        wordsPair.getRussianWord()));
    }
}
