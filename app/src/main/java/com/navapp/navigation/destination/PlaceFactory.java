package com.navapp.navigation.destination;

import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.PlaceAutocompleteRequest;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.PlaceDetails;
import com.navapp.navigation.destination.data.Place;

public class PlaceFactory {
    public static void requestPlace(GeoApiContext context, PlaceAutocompleteRequest.SessionToken token, AutocompletePrediction prediction, PendingResult.Callback<Place> callback) {
        new PlaceDetailsFactory(context, token).requestBasicPlaceDetails(prediction.placeId, new PendingResult.Callback<PlaceDetails>() {
            @Override
            public void onResult(PlaceDetails result) {
                callback.onResult(new Place(prediction, result));
            }

            @Override
            public void onFailure(Throwable e) {
                callback.onFailure(e);
            }
        });
    }
}
