package com.navapp.navigation.destination;

import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.model.AutocompletePrediction;

import java.util.Arrays;
import java.util.List;

public class PlaceAutocompletePredictionsFactory {
    private final GeoApiContext context;
    private final PlaceAutocompleteRequest.SessionToken session;

    public PlaceAutocompletePredictionsFactory(GeoApiContext context, PlaceAutocompleteRequest.SessionToken session) {
        this.context = context;
        this.session = session;
    }

    public void requestPredictions(String userInput, PendingResult.Callback<List<AutocompletePrediction>> callback) {
        PlacesApi.placeAutocomplete(context, userInput, session).setCallback(new PendingResult.Callback<AutocompletePrediction[]>() {
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
