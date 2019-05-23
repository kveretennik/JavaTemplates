package ru.constantin.patterns;

import java.io.BufferedReader;

public class SetBuilder extends CollectionBuilder {

    private EntrySet entrySet;

    @Override
    public void buildBase() {
        entrySet = new EntrySet();
    }

    @Override
    public void addWords(BufferedReader br) {
        entrySet.addWords(br);
    }

    @Override
    public EntryCollection getEntryWords() {
        return entrySet;
    }
}
