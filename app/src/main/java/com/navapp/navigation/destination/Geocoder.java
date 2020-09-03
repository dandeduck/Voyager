package com.navapp.navigation.destination;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PendingResult;
import com.google.maps.model.GeocodingResult;

public class Geocoder {
    private final GeoApiContext context;

    public Geocoder(GeoApiContext context) {
        this.context = context;
    }

    public void requestGeocodingResult(String placeId, PendingResult.Callback<GeocodingResult> callback) {
        GeocodingApi.newRequest(context).place(placeId).setCallback(new PendingResult.Callback<GeocodingResult[]>() {
            @Override
            public void onResult(GeocodingResult[] result) {
                callback.onResult(result[0]);
            }

            @Override
            public void onFailure(Throwable e) {
                callback.onFailure(e);
            }
        });
    }
}
