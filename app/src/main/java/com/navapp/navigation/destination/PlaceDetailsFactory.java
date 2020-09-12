package com.navapp.navigation.destination;

import com.google.maps.*;
import com.google.maps.model.PlaceDetails;

public class PlaceDetailsFactory {
    private final GeoApiContext context;
    private final PlaceAutocompleteRequest.SessionToken sessionToken;

    public PlaceDetailsFactory(GeoApiContext context, PlaceAutocompleteRequest.SessionToken sessionToken) {
        this.context = context;
        this.sessionToken = sessionToken;
    }

    public void requestBasicPlaceDetails(String placeId, PendingResult.Callback<PlaceDetails> callback) {
        PlacesApi.placeDetails(context, placeId, sessionToken)
                .fields(PlaceDetailsRequest.FieldMask.ADDRESS_COMPONENT, PlaceDetailsRequest.FieldMask.GEOMETRY_LOCATION)
                .setCallback(callback);
    }
}
