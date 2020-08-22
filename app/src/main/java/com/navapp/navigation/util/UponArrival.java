package com.navapp.navigation.util;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.navapp.functional.ConditionalFunction;

import java.io.IOException;

public abstract class UponArrival implements ConditionalFunction {
    private final GeoApiContext context;
    private final long minDurationInSeconds;

    protected UponArrival(GeoApiContext context, long minDurationInSeconds) {
        this.context = context;
        this.minDurationInSeconds = minDurationInSeconds;
    }

    @Override
    public boolean condition() throws InterruptedException, ApiException, IOException {
        return DistanceMatrixApi.newRequest(context)
                .origins(currentLocation())
                .destinations(nextLocation())
                .await()
                .rows[0].elements[0]
                .durationInTraffic.inSeconds <= minDurationInSeconds;
    }

    protected abstract LatLng currentLocation();
    protected abstract LatLng nextLocation();
}
