package com.navapp.navigation.destination.data;

import com.google.maps.model.AutocompletePrediction;

public class Location {
    private final String id;

    public Location(AutocompletePrediction prediction) {
        this(prediction.placeId);
    }

    public Location(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return id.equals(location.id);
    }
}
