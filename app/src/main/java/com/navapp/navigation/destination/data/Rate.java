package com.navapp.navigation.destination.data;

public class Rate {
    private final String name;
    private final double value; //no real need for currencies

    public static Rate empty() {
        return new Rate("NONE", 0);
    }

    public Rate(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
