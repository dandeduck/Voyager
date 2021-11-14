package com.navapp.navigation.route;

import com.google.maps.PendingResult;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Place;

import java.util.List;

public interface RouteFactory {
    void requestCreation(Place start, List<Destination> destinations, Place end, PendingResult.Callback<Route> callback);
}
