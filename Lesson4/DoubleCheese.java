package ru.constantin.patterns;

public class DoubleCheese extends PizzaDecorator {

    private float cost = 90.0f;

    public DoubleCheese(PizzaComponent component) {
        super(component);
    }

    public float getTotalCost() {
        return cost + component.getTotalCost();
    }

    public String getDescription() {
        return component.getDescription() + " double cheese";
    }
}