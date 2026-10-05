package ua.knu.flowershop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BouquetTest {
    
    private Bouquet bouquet;

    @BeforeEach
    void setUp() {
        bouquet = new Bouquet();
    }

    @Test
    void testCalculateTotalCost() {
      
        Flower rose = new Rose(150.0, 60.0, Freshness.FRESH, true);
        Accessory ribbon = new Ribbon(30.0);

        bouquet.addFlower(rose);
        bouquet.addAccessory(ribbon);

        assertEquals(180.0, bouquet.calculateTotalCost(), 0.01, "Вартість букета розрахована неправильно!");
    }

    @Test
    void testAddNullItems() {
        
        bouquet.addFlower(null);
        bouquet.addAccessory(null);

        assertTrue(bouquet.getFlowers().isEmpty(), "Список квітів має залишатися порожнім");
        assertTrue(bouquet.getAccessories().isEmpty(), "Список аксесуарів має залишатися порожнім");
    }
}