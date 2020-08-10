package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.Queue;

public interface RouteOptimizer {
    Queue<Destination> orderRoute(Location start, Route route);
}
