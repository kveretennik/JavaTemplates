package ru.constantin.patterns;

public class Hawaiian implements PizzaComponent {

    private String description = "Hawaiian";
    private float cost = 400.0f;
    private PizzaSize size;

    public Hawaiian(PizzaSize size) {
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