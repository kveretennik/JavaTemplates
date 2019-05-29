package ru.constantin.patterns;

public class ThinDough extends PizzaDecorator {

    private float cost = 0.0f;

    public ThinDough(PizzaComponent component) {
        super(component);
    }

    public float getTotalCost() {
        return cost + component.getTotalCost();
    }

    public String getDescription() {
        return component.getDescription() + " thin dough";
    }
}