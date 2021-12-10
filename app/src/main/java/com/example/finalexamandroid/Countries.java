package com.example.finalexamandroid;

public class Countries {
    private String countryName;
    private String countryCapital;
    private String places;
    private double price;
    private int image;
    private int flag;

    public Countries(String countryName, String countryCapital, String places, double price, int image, int flag) {
        this.countryName = countryName;
        this.countryCapital = countryCapital;
        this.places = places;
        this.price = price;
        this.image = image;
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
