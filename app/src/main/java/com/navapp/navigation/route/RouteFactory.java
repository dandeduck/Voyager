package com.navapp.navigation.route;

import com.google.maps.errors.ApiException;
import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.io.IOException;
import java.util.List;

public interface RouteFactory {
    Route create(Location start, List<Destination> destinations, Location end) throws InterruptedException, ApiException, IOException;
}
