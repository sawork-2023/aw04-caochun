package com.restpos.model;

import java.io.Serializable;
import java.util.UUID;

import com.opencsv.bean.CsvBindByPosition;

public class Product implements Serializable {

    private String id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private double price;

    private String image;

    public Product(String name, double price) {
        this(name, price, "/images/placeholder.png");
    }

    public Product(String name, double price, String image) {
        this(UUID.randomUUID().toString(), name, price, image);
    }

    public Product(String id, String name, double price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
