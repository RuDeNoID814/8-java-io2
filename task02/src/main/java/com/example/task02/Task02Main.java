package com.example.task02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) throws IOException {
        Path rootDir = Path.of("task02/src/main/resources");
        System.out.println(listFiles(rootDir));
    }

    public static List<Path> listFiles(Path rootDir) throws IOException {
        try (Stream<Path> paths = Files.walk(rootDir)) {
            return paths.filter(Files::isRegularFile).toList();
        }
    }
}