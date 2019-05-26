package ru.constantin.patterns;

public class DecoratorApp {
    public static void main(String args[]) {
        PizzaComponent pizza;

        pizza = new Margarita(PizzaSize.SMALL);
        System.out.println(pizza);

        pizza = new DoubleCheese(new ThinDough(new California(PizzaSize.BIG)));
        System.out.println(pizza);

        pizza = new DoubleCheese(new RedOnion(new Mushrooms(new Hawaiian(PizzaSize.REGULAR))));
        System.out.println(pizza);
    }
}
