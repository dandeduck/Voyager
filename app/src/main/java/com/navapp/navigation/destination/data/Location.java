package com.navapp.navigation.destination.data;

import android.location.Address;
import android.location.Geocoder;

import com.navapp.navigation.util.math.MathLocation;

import java.io.IOException;
import java.util.List;

public class Location implements MathLocation {
    private final Address address;
    private final android.location.Location location;

    public Location(Geocoder geocoder, String addressName, int wantedResult) throws IOException {
        this(geocoder.getFromLocationName(addressName, wantedResult + 1), wantedResult);
    }

    public Location(Geocoder geocoder, double latitude, double longitude, int wantedResult) throws IOException {
        this(geocoder.getFromLocation(latitude, longitude, wantedResult + 1), wantedResult);
    }

    public Location(List<Address> results, int wantedResult) {
        this(results.get(wantedResult));
    }

    public Location(Address address) {
        this.address = address;
        location = new android.location.Location(address.getFeatureName());
        location.setLatitude(address.getLatitude());
        location.setLongitude(address.getLongitude());
    }

    @Override
    public double cost(MathLocation destination) {
        if(!isLocation(destination))
            throw new IllegalArgumentException("Given Math location is not a Location");
        return location.distanceTo(((Location)destination).location);
    }

    public Address getAddress() {
        return address;
    }

    private boolean isLocation(Object o) {
        return o instanceof Location;
    }
}
