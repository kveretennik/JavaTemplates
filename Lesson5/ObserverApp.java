package ru.constantin.patterns;

public class ObserverApp {
    public static void main (String args[]) {
        Building building = new Building();
        building.fireSensor().addObserver(new FireService().getObserver());
        building.leakingSensor().addObserver(new WaterService().getObserver());
        building.energySensor().addObserver(new EnergyService().getObserver());
        building.entrySensor().addObserver(new GuardService().getObserver());
        building.fireNotify();
        building.leakingNotify();
        building.energyNotify();
        building.entryNotify();
    }
}