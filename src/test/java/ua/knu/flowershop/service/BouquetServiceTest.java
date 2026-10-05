package ua.knu.flowershop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.knu.flowershop.model.Bouquet;
import ua.knu.flowershop.model.Flower;
import ua.knu.flowershop.model.Freshness;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BouquetServiceTest {

    private BouquetService bouquetService;
    private Bouquet mockBouquet; 

    @BeforeEach
    void setUp() {
        bouquetService = new BouquetService();
        
        mockBouquet = mock(Bouquet.class);
    }

    @Test
    void testSortFlowersByFreshness() {
        
        Flower flower1 = mock(Flower.class);
        when(flower1.getFreshness()).thenReturn(Freshness.STALE);

        Flower flower2 = mock(Flower.class);
        when(flower2.getFreshness()).thenReturn(Freshness.FRESH);

        Flower flower3 = mock(Flower.class);
        when(flower3.getFreshness()).thenReturn(Freshness.NORMAL);

       
        when(mockBouquet.getFlowers()).thenReturn(Arrays.asList(flower1, flower2, flower3));

        
        List<Flower> sorted = bouquetService.sortFlowersByFreshness(mockBouquet);

       
        assertEquals(Freshness.FRESH, sorted.get(0).getFreshness());
        assertEquals(Freshness.NORMAL, sorted.get(1).getFreshness());
        assertEquals(Freshness.STALE, sorted.get(2).getFreshness());
    }

    @Test
    void testFindFlowersByStemLength() {
        Flower flower1 = mock(Flower.class);
        when(flower1.getStemLength()).thenReturn(40.0);

        Flower flower2 = mock(Flower.class);
        when(flower2.getStemLength()).thenReturn(50.0);

        Flower flower3 = mock(Flower.class);
        when(flower3.getStemLength()).thenReturn(60.0);

        when(mockBouquet.getFlowers()).thenReturn(Arrays.asList(flower1, flower2, flower3));

    
        List<Flower> found = bouquetService.findFlowersByStemLength(mockBouquet, 45.0, 55.0);


        assertEquals(1, found.size());
        assertEquals(50.0, found.get(0).getStemLength());
    }

    @Test
    void testFindFlowersByStemLength_InvalidRangeThrowsException() {
       
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bouquetService.findFlowersByStemLength(mockBouquet, 60.0, 40.0);
        });
        
      
        assertTrue(exception.getMessage().contains("Некоректно заданий діапазон"));
    }

    @Test
    void testFindFlowersByStemLength_NegativeLengthThrowsException() {
       
        assertThrows(IllegalArgumentException.class, () -> {
            bouquetService.findFlowersByStemLength(mockBouquet, -10.0, 50.0);
        });
    }

    @Test
    void testSortFlowersByFreshness_EmptyBouquet() {
       
        when(mockBouquet.getFlowers()).thenReturn(Arrays.asList());
        
        List<Flower> sorted = bouquetService.sortFlowersByFreshness(mockBouquet);
        
      
        assertTrue(sorted.isEmpty(), "Для порожнього букета має повертатися порожній список");
    }
}