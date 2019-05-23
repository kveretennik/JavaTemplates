package ru.constantin.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class EntryMap extends EntryCollection {
    private HashMap<String, HashSet<Integer>> entries;
    private int position;

    public EntryMap() {
        entries = new HashMap();
        position = 0;
    }

    @Override
    public void addWords(BufferedReader br) {
        String line;
        String[] words;
        HashSet<Integer> positions;
        try {
            while ((line = br.readLine()) != null) {
                words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if ((positions = entries.get(words[i])) != null) {
                        positions.add(++position);
                    } else {
                        positions = new HashSet<Integer>();
                        positions.add(++position);
                        entries.put(words[i], positions);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (String s : entries.keySet()) {
            sb.append(s);
            sb.append(" - ");
            sb.append(Arrays.toString(entries.get(s).toArray()));
            sb.append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
