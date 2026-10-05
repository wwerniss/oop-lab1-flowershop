package ua.knu.flowershop.service;

import ua.knu.flowershop.model.Bouquet;
import ua.knu.flowershop.model.Flower;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BouquetService {

    /**
     * Відсортувати квіти в букеті за свіжістю.
     */
    public List<Flower> sortFlowersByFreshness(Bouquet bouquet) {
        return bouquet.getFlowers().stream()
                .sorted(Comparator.comparing(Flower::getFreshness))
                .collect(Collectors.toList());
    }

    /**
     * Знайти квіти в букеті, що відповідають заданому діапазону довжин стебел.
     */
    public List<Flower> findFlowersByStemLength(Bouquet bouquet, double minLength, double maxLength) {
        if (minLength < 0 || maxLength < 0 || minLength > maxLength) {
            throw new IllegalArgumentException("Некоректно заданий діапазон довжини стебла!");
        }
        
        return bouquet.getFlowers().stream()
                .filter(flower -> flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength)
                .collect(Collectors.toList());
    }
}