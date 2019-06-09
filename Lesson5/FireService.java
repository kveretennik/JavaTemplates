package ru.constantin.patterns;

import java.util.Observable;
import java.util.Observer;

class FireService {
    private FireObserver fireObserver = new FireObserver();

    private class FireObserver implements Observer {
        public void update(Observable ob, Object a) {
            System.out.println("Fire service in transit!");
        }
    }

    public Observer getObserver() {
        return fireObserver;
    }
}

