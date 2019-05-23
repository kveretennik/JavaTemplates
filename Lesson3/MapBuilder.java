package ru.constantin.patterns;

import java.io.BufferedReader;

public class MapBuilder extends CollectionBuilder {

    private EntryMap entryMap;

    @Override
    public void buildBase() {
        entryMap = new EntryMap();
    }

    @Override
    public void addWords(BufferedReader br) {
        entryMap.addWords(br);
    }

    @Override
    public EntryCollection getEntryWords() {
        return entryMap;
    }
}
