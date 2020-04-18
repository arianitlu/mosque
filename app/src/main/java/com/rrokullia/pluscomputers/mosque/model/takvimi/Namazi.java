package com.rrokullia.pluscomputers.mosque.model.takvimi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Namazi implements Serializable {

    @SerializedName("Date")
    private String date;

    @SerializedName("Year")
    private String year;

    @SerializedName("Month")
    private String month;

    @SerializedName("Day")
    private String day;

    @SerializedName("WeekDay")
    private String weekDay;

    @SerializedName("Imsaku")
    private String imsaku;

    @SerializedName("Sabahu")
    private String sabahu;

    @SerializedName("Dielli")
    private String dielli;

    @SerializedName("Dreka")
    private String dreka;

    @SerializedName("Ikindija")
    private String ikindija;

    @SerializedName("Akshami")
    private String akshami;

    @SerializedName("Jacija")
    private String jacija;

    @SerializedName("Comments")
    private String comments;

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String value) {
        this.year = value;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String value) {
        this.month = value;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String value) {
        this.day = value;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String value) {
        this.weekDay = value;
    }

    public String getImsaku() {
        return imsaku;
    }

    public void setImsaku(String value) {
        this.imsaku = value;
    }

    public String getSabahu() {
        return sabahu;
    }

    public void setSabahu(String value) {
        this.sabahu = value;
    }

    public String getDielli() {
        return dielli;
    }

    public void setDielli(String value) {
        this.dielli = value;
    }

    public String getDreka() {
        return dreka;
    }

    public void setDreka(String value) {
        this.dreka = value;
    }

    public String getIkindija() {
        return ikindija;
    }

    public void setIkindija(String value) {
        this.ikindija = value;
    }

    public String getAkshami() {
        return akshami;
    }

    public void setAkshami(String value) {
        this.akshami = value;
    }

    public String getJacija() {
        return jacija;
    }

    public void setJacija(String value) {
        this.jacija = value;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String value) {
        this.comments = value;
    }

    @Override
    public String toString() {
        return "Namazi{" +
                "date='" + date + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", weekDay='" + weekDay + '\'' +
                ", imsaku='" + imsaku + '\'' +
                ", sabahu='" + sabahu + '\'' +
                ", dielli='" + dielli + '\'' +
                ", dreka='" + dreka + '\'' +
                ", ikindija='" + ikindija + '\'' +
                ", akshami='" + akshami + '\'' +
                ", jacija='" + jacija + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}

