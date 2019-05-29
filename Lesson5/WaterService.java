package ru.constantin.patterns;

import java.util.Observable;
import java.util.Observer;

class WaterService {
    private WaterObserver waterObserver = new WaterObserver();

    private class WaterObserver implements Observer {
        public void update(Observable ob, Object a) {
            System.out.println("Water service in transit!");
        }
    }

    public Observer getObserver() {
        return waterObserver;
    }
}
