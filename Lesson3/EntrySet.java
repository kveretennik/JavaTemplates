package ru.constantin.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;

public class EntrySet extends EntryCollection {
    private TreeSet<String> entries;

    public EntrySet() {
        entries = new TreeSet<>();
    }

    @Override
    public void addWords(BufferedReader br) {
        String line;
        String[] words;
        try {
            while ((line = br.readLine()) != null) {
                words = line.split(" ");
                entries.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(entries.toArray());
    }
}
