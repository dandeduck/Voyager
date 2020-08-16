package com.navapp.navigation.destination.data;

import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;

public class Location {
    private final Address address;

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
    }

    public Address getAddress() {
        return address;
    }
}
