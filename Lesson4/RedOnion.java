package ru.constantin.patterns;

public class RedOnion extends PizzaDecorator {

    private float cost = 50.0f;

    public RedOnion(PizzaComponent component) {
        super(component);
    }

    public float getTotalCost() {
        return cost + component.getTotalCost();
    }

    public String getDescription() {
        return component.getDescription() + " red onion";
    }
}