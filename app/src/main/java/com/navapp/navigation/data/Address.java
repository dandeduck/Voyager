package com.navapp.navigation.data;

public class Address {
    private final double latitude;
    private final double longitude;

    public static Address empty() {
        return new Address(0, 0); //null island
    }

    public Address(String addressText) {
        this(0, 0); //implement find through Waze.
    }

    public Address(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double latitude() {
        return latitude;
    }

    public double longitude() {
        return longitude;
    }
}
