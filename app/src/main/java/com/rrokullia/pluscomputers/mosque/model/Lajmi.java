package com.rrokullia.pluscomputers.mosque.model;

public class Lajmi {

    private int featureMedia;
    private String title;
    private String category;
    private String image;
    private int color;
    private String description;

    public Lajmi(int featureMedia,String title, String category,int color, String description) {
        this.featureMedia = featureMedia;
        this.title = title;
        this.category = category;
        this.color = color;
        this.description = description;
    }

    public int getFeatureMedia() {
        return featureMedia;
    }

    public void setFeatureMedia(int featureMedia) {
        this.featureMedia = featureMedia;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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