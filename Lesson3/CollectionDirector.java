package ru.constantin.patterns;

import java.io.BufferedReader;

public class CollectionDirector {

    private CollectionBuilder cb;

    public CollectionDirector(CollectionBuilder cb) {
        this.cb = cb;
    }

    public EntryCollection makeCollection(BufferedReader br) {
        cb.buildBase();
        cb.addWords(br);
        return cb.getEntryWords();
    }

}
