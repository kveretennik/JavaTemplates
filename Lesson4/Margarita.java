package ru.constantin.patterns;

public class Margarita implements PizzaComponent {

    private float cost = 300.0f;
    private String description = "Margarita";
    private PizzaSize size;

    public Margarita(PizzaSize size) {
        this.size = size;
    }

    @Override
    public float getTotalCost() {
        return (float)((int)Math.round(cost * size.getCoefficient() * 100)) / 100;
    }

    @Override
    public String getDescription() {
        return description + " " + size;
    }

    @Override
    public String toString() {
        return getDescription() + ": $" + getTotalCost();
    }
}
