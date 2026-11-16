package com.example.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class Task01Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println(extractSoundName(new File("task01/src/main/resources/3727.mp3")));
    }

    public static String extractSoundName(File file) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("ffprobe", "-v", "error", "-of", "flat", "-show_format", file.getAbsolutePath());
        Process process = pb.start();
        BufferedReader reader = process.inputReader();

        String line;
        while ((line = reader.readLine()) != null) {
            String prefix = "format.tags.title=";
            if (line.startsWith(prefix)) {
                String title = line.substring(prefix.length());

                if (title.startsWith("\"") && title.endsWith("\"") && title.length() >= 2) {
                    title = title.substring(1, title.length() - 1);
                }
                return title;
            }
        }
        return "sound name";
    }
}
