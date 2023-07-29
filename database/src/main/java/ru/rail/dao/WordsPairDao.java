package ru.rail.dao;

import ru.rail.entety.WordsPair;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WordsPairDao {

    public Map<String, String> wordsPairs;

    public WordsPairDao() {
        wordsPairs = new HashMap<>();
        wordsPairs.put("привет", "hello");
        wordsPairs.put("мир", "world");
        wordsPairs.put("книга", "book");
        wordsPairs.put("компьютер", "computer");
        wordsPairs.put("кофе", "coffee");
    }

    public Optional<WordsPair> getRussianByEnglish(String englishWord) {
        return wordsPairs.entrySet().stream()
                .filter(word -> word.getValue().equals(englishWord))
                .map(word -> new WordsPair(word.getKey(), word.getValue()))
                .findFirst();
    }

    public Optional<WordsPair> getEnglishByRussian(String russianWord) {
        return Optional.ofNullable(wordsPairs.get(russianWord))
                .map(word -> new WordsPair(word, russianWord));
    }
}
