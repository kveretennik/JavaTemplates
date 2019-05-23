package ru.constantin.patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BuilderApp {
    public static void main(String[] args) {
        String fileName = "file.txt";

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            CollectionDirector cd = new CollectionDirector(new SetBuilder());
            EntryCollection entrySet = cd.makeCollection(br);
            System.out.println(entrySet);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            CollectionDirector cd = new CollectionDirector(new MapBuilder());
            EntryCollection entryMap = cd.makeCollection(br);
            System.out.println(entryMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
