package com.navapp.navigation.route;

import com.google.maps.PendingResult;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.List;

public interface RouteFactory {
    void requestCreation(Location start, List<Destination> destinations, Location end, PendingResult.Callback<Route> callback);
}
