package com.example.zh20201218.application;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineSplitter {
    public List<String> splitLinesToWords(List<String> lines) {
        List<String> words = new ArrayList<>();
        lines.stream()
                .map(line -> StringUtils.replace(line, ",", ""))
                .map(line -> StringUtils.replace(line, ".", ""))
                .map(line -> StringUtils.lowerCase(line))
                .forEach(line -> {
                    List<String> lineWords = Arrays.asList(line.split(" "));
                    words.addAll(lineWords);
                });
        return words;
    }
}
