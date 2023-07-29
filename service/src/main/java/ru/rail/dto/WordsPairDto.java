package ru.rail.dto;

public class WordsPairDto {
    private String russianWord;
    private String englishWord;


    public WordsPairDto(String russianWord, String englishWord) {
        this.russianWord = russianWord;
        this.englishWord = englishWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getRussianWord() {
        return russianWord;
    }

    public void setRussianWord(String russianWord) {
        this.russianWord = russianWord;
    }
}
//hello