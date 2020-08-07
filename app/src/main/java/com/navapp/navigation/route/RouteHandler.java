package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.ArrayDeque;
import java.util.Deque;

public class RouteHandler {
    private final Route route;
    private final Deque<Destination> remaining;

    public RouteHandler(Route route) {
        this(route, new ArrayDeque<>(route.destinations()));
    }

    public RouteHandler(Route route, Deque<Destination> remaining) {
        this.route = route;
        this.remaining = remaining;
    }

    public RouteHandler addDestination(Address currentAddress, Destination newDestination) {
        remaining.add(newDestination);

        return new RouteHandler(route.addDestination(newDestination), RoutOptimizer.optimizeRoute(currentAddress, remaining, route.end()));
    }

    public RouteHandler changeEnd(Address currentAddress, Address endAddress) {
        return new RouteHandler(route.changeEnd(endAddress), RoutOptimizer.optimizeRoute(currentAddress, remaining, endAddress));
    }

    public Destination nextDestination() {
        return remaining.poll();
    }

    public double sum() {
        double sum = 0;

        for (Destination dest: route.destinations()) {
            sum += dest.isDelivered() ? dest.rate() : 0;
        }

        return sum;
    }
}
