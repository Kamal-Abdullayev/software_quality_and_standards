package com.taltech.demo.model;

public class Product {
    private long id;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product() {
    }

    public Product(long id, String name, String description, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
}
