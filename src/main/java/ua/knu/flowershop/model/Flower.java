package ua.knu.flowershop.model;

public abstract class Flower {
    private String name;
    private double price;
    private double stemLength;
    private Freshness freshness;

    public Flower(String name, double price, double stemLength, Freshness freshness) {
        if (price < 0 || stemLength <= 0) {
            throw new IllegalArgumentException("Ціна та довжина стебла повинні бути більшими за нуль!");
        }
        this.name = name;
        this.price = price;
        this.stemLength = stemLength;
        this.freshness = freshness;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getStemLength() {
        return stemLength;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    @Override
    public String toString() {
        return String.format("%s [Ціна: %.2f, Стебло: %.1f см, Свіжість: %s]", 
                name, price, stemLength, freshness);
    }
}