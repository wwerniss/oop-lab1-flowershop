package ua.knu.flowershop.model;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    // Інкапсуляція
    private List<Flower> flowers;
    private List<Accessory> accessories;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        if (flower != null) {
            flowers.add(flower);
        }
    }

    public void addAccessory(Accessory accessory) {
        if (accessory != null) {
            accessories.add(accessory);
        }
    }

    public List<Flower> getFlowers() {
        return new ArrayList<>(flowers);
    }

    public List<Accessory> getAccessories() {
        return new ArrayList<>(accessories);
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        
        for (Flower flower : flowers) {
            totalCost += flower.getPrice();
        }
        
        for (Accessory accessory : accessories) {
            totalCost += accessory.getPrice();
        }
        
        return totalCost;
    }

    @Override
    public String toString() {
        return String.format("Букет [Квітів: %d, Аксесуарів: %d, Загальна вартість: %.2f]", 
                flowers.size(), accessories.size(), calculateTotalCost());
    }
}