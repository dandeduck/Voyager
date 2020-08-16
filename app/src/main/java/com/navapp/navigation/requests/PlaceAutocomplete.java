package com.navapp.navigation.requests;

import com.google.maps.GeoApiContext;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.AutocompletePrediction;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PlaceAutocomplete {
    private final GeoApiContext context;
    private final PlaceAutocompleteRequest.SessionToken sessionToken;

    public PlaceAutocomplete(GeoApiContext context, PlaceAutocompleteRequest.SessionToken sessionToken) {
        this.context = context;
        this.sessionToken = sessionToken;
    }

    List<AutocompletePrediction> predictions(String address) throws InterruptedException, ApiException, IOException {
        return Arrays.asList(PlacesApi.placeAutocomplete(context, address, sessionToken).await());
    }
}
