package com.navapp.navigation.destination.data;

import com.navapp.navigation.util.math.MathDestination;

public class Address implements MathDestination {
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

    @Override
    public double cost(MathDestination destination) {
        return 0;
    }
}
