package com.example.pluscomputers.mosque.model;

public class Anetaresia {

    private String emri;
    private String pozita;
    private int image;

    public Anetaresia(String emri,String pozita, int image) {
        this.emri = emri;
        this.pozita = pozita;
        this.image = image;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getPozita() {
        return pozita;
    }

    public void setPozita(String pozita) {
        this.pozita = pozita;
    }

    public int getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
