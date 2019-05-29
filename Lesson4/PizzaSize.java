package ru.constantin.patterns;

public enum PizzaSize {

    SMALL(0.9f, "small"),
    REGULAR(1.0f, "regular"),
    BIG(1.2f, "big");

    private float coefficient;
    private String description;

    PizzaSize(float coefficient, String description) {
        this.coefficient = coefficient;
        this.description = description;
    }

    public float getCoefficient() {
        return coefficient;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}
