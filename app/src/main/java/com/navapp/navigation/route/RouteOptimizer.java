package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.Collection;
import java.util.Queue;

public interface RouteOptimizer {
    Queue<Destination> optimizeRoute(Location start, Collection<Destination> destinations, Location end);
}
