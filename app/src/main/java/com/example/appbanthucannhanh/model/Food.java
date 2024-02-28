package com.example.appbanthucannhanh.model;

import java.io.Serializable;

public class Food implements Serializable {
    private int idFood;
    private String nameFood;
    private int priceFood;
    private String introFood;
    private int imageFood;
    private String typeFood;

    public Food() {

    }

    public Food(int idFood, String nameFood, int priceFood, String introFood, int imageFood, String typeFood) {
        this.idFood = idFood;
        this.nameFood = nameFood;
        this.priceFood = priceFood;
        this.introFood = introFood;
        this.imageFood = imageFood;
        this.typeFood = typeFood;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
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

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }
}
