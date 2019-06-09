package ru.constantin.patterns;

import java.util.Observable;
import java.util.Observer;

class GuardService {
    private GuardObserver guardObserver = new GuardObserver();

    private class GuardObserver implements Observer {
        public void update(Observable ob, Object a) {
            System.out.println("Guard in transit!");
        }
    }

    public Observer getObserver() {
        return guardObserver;
    }
}
