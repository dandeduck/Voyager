package com.navapp.navigation.destination;

import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PlaceAutocompletePredictionsFactory {
    private final GeoApiContext context;
    private final PlaceAutocompleteRequest.SessionToken sessionToken;

    public PlaceAutocompletePredictionsFactory(GeoApiContext context, PlaceAutocompleteRequest.SessionToken sessionToken) {
        this.context = context;
        this.sessionToken = sessionToken;
    }

    public void requestPredictions(String userInput, PendingResult.Callback<List<AutocompletePrediction>> callback) {
        PlacesApi.placeAutocomplete(context, userInput, sessionToken).setCallback(new PendingResult.Callback<AutocompletePrediction[]>() {
            @Override
            public void onResult(AutocompletePrediction[] result) {
                callback.onResult(Arrays.asList(result));
            }

            @Override
            public void onFailure(Throwable e) {
                callback.onFailure(e);
            }
        });
    }
}
