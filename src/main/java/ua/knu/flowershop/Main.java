package ua.knu.flowershop;

import ua.knu.flowershop.model.*;
import ua.knu.flowershop.service.BouquetService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        
        Flower rose1 = new Rose(150.0, 60.5, Freshness.FRESH, true);
        Flower rose2 = new Rose(120.0, 50.0, Freshness.NORMAL, false);
        Flower tulip = new Tulip(80.0, 40.0, Freshness.STALE);
        
        Accessory ribbon = new Ribbon(30.0);
        Accessory wrapper = new Wrapper(50.0);

        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(rose1);
        bouquet.addFlower(rose2);
        bouquet.addFlower(tulip);
        bouquet.addAccessory(ribbon);
        bouquet.addAccessory(wrapper);

        BouquetService service = new BouquetService();

        System.out.println("--- Зібрано новий букет ---");
        System.out.println(bouquet);

        System.out.println("\n--- Квіти після сортування за свіжістю ---");
        List<Flower> sortedFlowers = service.sortFlowersByFreshness(bouquet);
        sortedFlowers.forEach(System.out::println);

        double min = 45.0;
        double max = 55.0;
        System.out.println(String.format("\n--- Пошук квітів зі стеблом від %.1f до %.1f см ---", min, max));
        List<Flower> foundFlowers = service.findFlowersByStemLength(bouquet, min, max);
        foundFlowers.forEach(System.out::println);
    }
}