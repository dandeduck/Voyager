package com.navapp.navigation.util;

import android.location.Location;

import com.google.maps.model.LatLng;

public abstract class SimpleUponArrival extends UponArrival {
    private final Location current;
    private final Location next;
    protected SimpleUponArrival(long minDistance) {
        super(minDistance);
        current = new Location("current");
        next = new Location("next");
    }

    @Override
    protected double distance() {
        LatLng currentLatLng = currentLocation();
        LatLng nextLatLng = nextLocation();

        current.setLatitude(currentLatLng.lat);
        current.setLongitude(currentLatLng.lng);
        next.setLatitude(nextLatLng.lat);
        next.setLongitude(nextLatLng.lng);

        return current.distanceTo(next);
    }

    protected abstract LatLng currentLocation();
    protected abstract LatLng nextLocation();
}
