package dev.m3s.programming2.homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordList {
    private List<String> words;

    public WordList(String textFileName) {
        words = new ArrayList<>();
        try {
            File myObj = new File(textFileName);
            Scanner reader = new Scanner(myObj);
            while (reader.hasNextLine()) {
                String data = reader.nextLine().toLowerCase();
                words.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // No output as required
        }
    }

    public List<String> giveWords() {
        return words;
    }
}