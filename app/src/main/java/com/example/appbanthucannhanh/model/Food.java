package com.example.appbanthucannhanh.model;

import java.io.Serializable;

public class Food implements Serializable {
    private String nameFood;
    private int priceFood;
    private String introFood;
    private int imageFood;

    public Food() {
    }

    public Food(String nameFood, int priceFood, String introFood, int imageFood) {
        this.nameFood = nameFood;
        this.priceFood = priceFood;
        this.introFood = introFood;
        this.imageFood = imageFood;
    }

    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        this.nameFood = nameFood;
    }

    public int getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(int priceFood) {
        this.priceFood = priceFood;
    }

    public String getIntroFood() {
        return introFood;
    }

    public void setIntroFood(String introFood) {
        this.introFood = introFood;
    }

    public int getImageFood() {
        return imageFood;
    }

    public void setImageFood(int imageFood) {
        this.imageFood = imageFood;
    }
}
