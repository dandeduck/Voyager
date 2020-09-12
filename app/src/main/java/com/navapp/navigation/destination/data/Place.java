package com.navapp.navigation.destination.data;

import com.google.maps.*;
import com.google.maps.model.AutocompletePrediction;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceDetails;

public class Place {
    private final String id;
    private final String address;
    private final LatLng position;

    public Place(AutocompletePrediction prediction, PlaceDetails details) {
        this(prediction.placeId, details.formattedAddress, details.geometry.location);
    }

    public Place(String id, String address, LatLng position) {
        this.id = id;
        this.address = address;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public LatLng getPosition() {
        return position;
    }

    public void requestIdRefresh(GeoApiContext context, PlaceAutocompleteRequest.SessionToken session, PendingResult.Callback<Place> callback) {
        PlacesApi.placeDetails(context, id, session)
                .fields(PlaceDetailsRequest.FieldMask.PLACE_ID)
                .setCallback(new PendingResult.Callback<PlaceDetails>() {
                    @Override
                    public void onResult(PlaceDetails result) {
                        callback.onResult(new Place(result.placeId, address, position));
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return id.equals(place.id) &&
                address.equals(place.address) &&
                position.equals(place.position);
    }

    @Override
    public String toString() {
        return String.format("address: %s - position: %s - id: %s", address, position, id);
    }
}
