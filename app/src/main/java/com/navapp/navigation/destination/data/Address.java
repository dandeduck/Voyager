package com.navapp.navigation.destination.data;

public class Address {
    private final double latitude;
    private final double longitude;

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
