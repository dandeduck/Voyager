package com.navapp.navigation.destination.data;

import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;

public class Location {
    private final String id;
    private final String address;
    private final LatLng position;

    public Location(AutocompletePrediction prediction, GeocodingResult result) {
        this(prediction.placeId, result.formattedAddress, result.geometry.location);
    }

    public Location(String id, String address, LatLng position) {
        this.id = id;
        this.address = address;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public LatLng getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return id.equals(location.id) &&
                address.equals(location.address) &&
                position.equals(location.position);
    }

    @Override
    public String toString() {
        return String.format("address: %s - position: %s - id: %s", address, position, id);
    }
}
