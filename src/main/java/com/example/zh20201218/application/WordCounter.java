package com.example.zh20201218.application;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {
    public Map<String, Integer> getWordCounts(List<String> words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, Collections.frequency(words, word));
        }
        return wordCounts;
    }
}
