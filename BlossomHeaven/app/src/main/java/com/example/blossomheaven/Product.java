package com.example.blossomheaven;

public class Product {
    private String name;
    private double price;
    private int imageId;
    private String description;

    public Product(String name, double price, int imageId, String description) {
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }
}
