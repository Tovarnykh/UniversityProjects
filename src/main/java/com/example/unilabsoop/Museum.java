package com.example.unilabsoop;

public class Museum {
    public String name;
    public String city;
    public String adress;
    public String theme;
    public String form;
    public String cost;
    public Museum(){

    }
    public Museum(String name, String city, String adress, String theme, String form, String cost) {
        this.name = name;
        this.city = city;
        this.adress = adress;
        this.theme = theme;
        this.form = form;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAdress() {
        return adress;
    }

    public String getTheme() {
        return theme;
    }

    public String getForm() {
        return form;
    }

    public String getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }
}
