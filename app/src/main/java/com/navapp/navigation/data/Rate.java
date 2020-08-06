package com.navapp.navigation.data;

public class Rate {
    private final String name;
    private final double value; //no real need for currencies

    public Rate(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public double value() {
        return value;
    }
}
