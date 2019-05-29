package ru.constantin.patterns;

import java.util.Observable;
import java.util.Observer;

class EnergyService {
    private EnergyObserver energyObserver = new EnergyObserver();

    private class EnergyObserver implements Observer {
        public void update(Observable ob, Object a) {
            System.out.println("Energy in transit!");
        }
    }

    public Observer getObserver() {
        return energyObserver;
    }
}
