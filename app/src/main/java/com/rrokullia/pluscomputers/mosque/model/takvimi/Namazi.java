package com.rrokullia.pluscomputers.mosque.model.takvimi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Namazi implements Serializable {
    @SerializedName("Muaji")
    private String muaji;

    @SerializedName("Data")
    private String data;

    @SerializedName("Dita")
    private String dita;

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

    @SerializedName("Vërejtje")
    private String vrejtje;

    public String getMuaji() {
        return muaji;
    }

    public void setMuaji(String value) {
        this.muaji = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }

    public String getDita() {
        return dita;
    }

    public void setDita(String value) {
        this.dita = value;
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

    public String getVrejtje() {
        return vrejtje;
    }

    public void setVrejtje(String value) {
        this.vrejtje = value;
    }

    @Override
    public String toString() {
        return "Namazi{" +
                "muaji=" + muaji +
                ", data='" + data + '\'' +
                ", dita=" + dita +
                ", imsaku='" + imsaku + '\'' +
                ", sabahu='" + sabahu + '\'' +
                ", dielli='" + dielli + '\'' +
                ", dreka='" + dreka + '\'' +
                ", ikindija='" + ikindija + '\'' +
                ", akshami='" + akshami + '\'' +
                ", jacija='" + jacija + '\'' +
                ", vrejtje='" + vrejtje + '\'' +
                '}';
    }
}
