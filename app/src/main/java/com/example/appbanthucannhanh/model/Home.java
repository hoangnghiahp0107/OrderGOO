package com.example.appbanthucannhanh.model;

public class Home {
    private String name;
    private String price;
    private String description;
    private int imageResource;

    public Home(String name, int imageResource, String price, String description) {
        this.name = name;
        this.imageResource = imageResource;
        this.price = price;
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
