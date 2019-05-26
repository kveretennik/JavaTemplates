package ru.constantin.patterns;

public class Mushrooms extends PizzaDecorator {

    private float cost = 120.0f;

    public Mushrooms(PizzaComponent component) {
        super(component);
    }

    public float getTotalCost() {
        return cost + component.getTotalCost();
    }

    public String getDescription() {
        return component.getDescription() + " mushrooms";
    }
}