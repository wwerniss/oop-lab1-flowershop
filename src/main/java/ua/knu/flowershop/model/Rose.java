package ua.knu.flowershop.model;

public class Rose extends Flower {
    private boolean hasThorns; 

    public Rose(double price, double stemLength, Freshness freshness, boolean hasThorns) {
        super("Троянда", price, stemLength, freshness);
        this.hasThorns = hasThorns;
    }

    public boolean isHasThorns() {
        return hasThorns;
    }

    @Override
    public String toString() {
        return super.toString() + (hasThorns ? " (З шипами)" : " (Без шипів)");
    }
}