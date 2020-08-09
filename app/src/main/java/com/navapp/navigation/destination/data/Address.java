package com.navapp.navigation.destination.data;

public class Address {
    private final String addressName;
    private final double latitude;
    private final double longitude;

    public Address(String addressName, double latitude, double longitude) {
        this.addressName = addressName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getAddressName() {
        return addressName;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
