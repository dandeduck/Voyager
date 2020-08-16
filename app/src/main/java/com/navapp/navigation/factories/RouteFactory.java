package com.navapp.navigation.factories;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;
import com.navapp.navigation.route.Route;

import java.util.List;

public interface RouteFactory {
    Route create(Location start, List<Destination> destinations, Location end);
}
