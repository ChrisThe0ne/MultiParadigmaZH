package com.example.zh20201218.application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {
    private Path fileToRead;

    public FileReader(Path fileToRead) {
        this.fileToRead = fileToRead;
    }

    public List<String> readAll() throws IOException {
        return Files.readAllLines(fileToRead);
    }
}
