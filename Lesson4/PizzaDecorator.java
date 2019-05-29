package ru.constantin.patterns;

public abstract class PizzaDecorator implements PizzaComponent {
    protected PizzaComponent component;

    public PizzaDecorator(PizzaComponent component) {
        this.component = component;
    }

    public float getTotalCost() {
        return component.getTotalCost();
    }

    public String getDescription() {
        return component.getDescription();
    }

    @Override
    public String toString() {
        return getDescription() + ": $" + getTotalCost();
    }
}
