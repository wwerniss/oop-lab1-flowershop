package ua.knu.flowershop.service;

import ua.knu.flowershop.model.Flower;
import ua.knu.flowershop.model.Freshness;
import ua.knu.flowershop.model.Rose;
import ua.knu.flowershop.model.Tulip;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileInitializer {

    public static List<Flower> loadFlowers(String filePath) {
        List<Flower> flowers = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                
                String[] parts = line.split(",");
                String type = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                double length = Double.parseDouble(parts[2].trim());
                Freshness freshness = Freshness.valueOf(parts[3].trim());

                if (type.equalsIgnoreCase("Rose")) {
                    boolean hasThorns = Boolean.parseBoolean(parts[4].trim());
                    flowers.add(new Rose(price, length, freshness, hasThorns));
                } else if (type.equalsIgnoreCase("Tulip")) {
                    flowers.add(new Tulip(price, length, freshness));
                }
            }
            System.out.println("Успішно завантажено квіти з файлу!");
            
        } catch (IOException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Помилка парсингу даних: " + e.getMessage());
        }
        
        return flowers;
    }
}