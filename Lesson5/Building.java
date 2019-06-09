package ru.constantin.patterns;

import java.util.Observable;

public class Building {
    private boolean isOnFire;
    private boolean isLeaking;
    private boolean isDeEnergized;
    private boolean isIllegalEntry;

    private OFNotifier ofNotifier = new OFNotifier();
    private LNotifier lNotifier = new LNotifier();
    private DENotifier deNotifier = new DENotifier();
    private IENotifier ieNotifier = new IENotifier();

    public Building() {
        isOnFire = false;
        isLeaking = false;
        isDeEnergized = false;
        isIllegalEntry = false;
    }

    public Observable fireSensor() {
        return ofNotifier;
    }

    public Observable leakingSensor() {
        return lNotifier;
    }

    public Observable energySensor() {
        return deNotifier;
    }

    public Observable entrySensor() {
        return ieNotifier;
    }

    public void fireNotify() {
        isOnFire = true;
        ofNotifier.notifyObservers();
    }

    public void leakingNotify() {
        isLeaking = true;
        lNotifier.notifyObservers();
    }

    public void energyNotify() {
        isDeEnergized = true;
        deNotifier.notifyObservers();
    }

    public void entryNotify() {
        isIllegalEntry = true;
        ieNotifier.notifyObservers();
    }

    private class OFNotifier extends Observable {
        private boolean alreadyNotified = false;

        @Override
        public void notifyObservers() {
            if (isOnFire && !alreadyNotified) {
                setChanged();
                super.notifyObservers();
            }
            alreadyNotified = true;
        }

        public void eliminate() {
            alreadyNotified = false;
        }
    }

    private class LNotifier extends Observable {
        private boolean alreadyNotified = false;

        @Override
        public void notifyObservers() {
            if (isLeaking && !alreadyNotified) {
                setChanged();
                super.notifyObservers();
            }
            alreadyNotified = true;
        }

        public void eliminate() {
            alreadyNotified = false;
        }
    }

    private class DENotifier extends Observable {
        private boolean alreadyNotified = false;

        @Override
        public void notifyObservers() {
            if (isDeEnergized && !alreadyNotified) {
                setChanged();
                super.notifyObservers();
            }
            alreadyNotified = true;
        }

        public void eliminate() {
            alreadyNotified = false;
        }
    }

    private class IENotifier extends Observable {
        private boolean alreadyNotified = false;

        @Override
        public void notifyObservers() {
            if (isIllegalEntry && !alreadyNotified) {
                setChanged();
                super.notifyObservers();
            }
            alreadyNotified = true;
        }

        public void eliminate() {
            alreadyNotified = false;
        }
    }
}
