package com.example.zh20201218;

import com.example.zh20201218.application.FileReader;
import com.example.zh20201218.application.LineSplitter;
import com.example.zh20201218.application.WordCounter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class Zh20201218Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Zh20201218Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.err.println("Nincs megadva file");
            return;
        }
        System.out.println(args[0]);
        Path fileLocation = Paths.get(args[0]);
        FileReader fileReader = new FileReader(fileLocation);
        LineSplitter lineSplitter = new LineSplitter();
        try {
            List<String> words = lineSplitter.splitLinesToWords(fileReader.readAll());
            WordCounter wordCounter = new WordCounter();
            Map<String, Integer> wordCounts = wordCounter.getWordCounts(words);
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                String k = entry.getKey();
                Integer v = entry.getValue();
                System.out.println(k + " : " + v);
            }
        } catch (IOException e) {
            System.err.println("Nem létezik a file");
        }
    }
}
