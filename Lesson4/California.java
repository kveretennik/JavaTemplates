package ru.constantin.patterns;

public class California implements PizzaComponent {

    private String description = "California";
    private float cost = 500.0f;
    private PizzaSize size;

    public California(PizzaSize size) {
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
