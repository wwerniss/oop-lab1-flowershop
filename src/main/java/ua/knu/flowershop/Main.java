package ua.knu.flowershop;

import ua.knu.flowershop.model.*;
import ua.knu.flowershop.service.BouquetService;
import ua.knu.flowershop.service.FileInitializer;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet();

        List<Flower> loadedFlowers = FileInitializer.loadFlowers("flowers.txt");
        for (Flower flower : loadedFlowers) {
            bouquet.addFlower(flower);
        }

        Accessory ribbon = new Ribbon(30.0);
        Accessory wrapper = new Wrapper(50.0);
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