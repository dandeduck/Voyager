package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

public class RouteHandler {
    private Route route;
    private int currentDestination;

    public RouteHandler(Route route) {
        this.route = route;
        currentDestination = -1;
    }

    public Destination nextDestination() {
        currentDestination++;
        return route.destinations().get(currentDestination);
    }

    public Route optimizeRoute(Address start) {
        return route;
    }

    public double sum() {
        double sum = 0;

        for (Destination dest: route.destinations()) {
            sum += dest.isDelivered() ? dest.rate() : 0;
        }

        return sum;
    }
}
