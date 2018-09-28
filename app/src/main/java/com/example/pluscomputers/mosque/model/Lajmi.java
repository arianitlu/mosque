package com.example.pluscomputers.mosque.model;

public class Lajmi {

    private String title;
    private String category;
    private int image;
    private int color;
    private String description;

    public Lajmi(String title, String category, int image, int color, String description) {
        this.title = title;
        this.category = category;
        this.image = image;
        this.color = color;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}