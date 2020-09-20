package com.navapp.navigation.destination;

import com.google.maps.*;
import com.google.maps.model.PlaceDetails;

public class PlaceDetailsFactory {
    private final GeoApiContext context;
    private final PlaceAutocompleteRequest.SessionToken session;

    public PlaceDetailsFactory(GeoApiContext context, PlaceAutocompleteRequest.SessionToken session) {
        this.context = context;
        this.session = session;
    }

    public void requestBasicPlaceDetails(String placeId, PendingResult.Callback<PlaceDetails> callback) {
        PlacesApi.placeDetails(context, placeId, session)
                .fields(PlaceDetailsRequest.FieldMask.ADDRESS_COMPONENT, PlaceDetailsRequest.FieldMask.GEOMETRY_LOCATION_LAT, PlaceDetailsRequest.FieldMask.GEOMETRY_LOCATION_LNG)
                .setCallback(callback);
    }
}
