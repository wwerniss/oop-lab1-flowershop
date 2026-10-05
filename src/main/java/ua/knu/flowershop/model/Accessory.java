package ua.knu.flowershop.model;

public abstract class Accessory {
    private String name;
    private double price;

    public Accessory(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна аксесуара не може бути від'ємною!");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s [Ціна: %.2f]", name, price);
    }
}