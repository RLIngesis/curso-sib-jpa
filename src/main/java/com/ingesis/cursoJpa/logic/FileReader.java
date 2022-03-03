package com.ingesis.cursoJpa.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ingesis.cursoJpa.TimeTracker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileReader {
    private final TimeTracker timeTracker;
    @Value("${com.ingesis.csvfile}")
    private String filename;

    @Autowired
    public FileReader(TimeTracker timeTracker) {
        this.timeTracker = timeTracker;
    }

    public List<String> readAllLines() throws IOException {
        timeTracker.start("ReadFile");
        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        timeTracker.stop("ReadFile");
        return lines;
    }
}
