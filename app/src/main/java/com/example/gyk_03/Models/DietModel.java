package com.example.gyk_03.Models;

public class DietModel {
    private String dietName;
    private int calorie, imageId;

    public DietModel(String dietName, int calorie, int imageId) {
        this.dietName = dietName;
        this.calorie = calorie;
        this.imageId = imageId;
    }

    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
