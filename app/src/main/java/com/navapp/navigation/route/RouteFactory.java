package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.List;

public interface RouteFactory {
    Route create(Location start, List<Destination> destinations, Location end);
}
