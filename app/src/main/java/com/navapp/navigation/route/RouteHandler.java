package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.ArrayDeque;
import java.util.Queue;

public class RouteHandler {
    private final Route route;
    private final Queue<Destination> remaining;
    private final RouteOptimizer optimizer;

    public RouteHandler(Route route, RouteOptimizer optimizer) {
        this(route, new ArrayDeque<>(route.getDestinations()), optimizer);
    }

    public RouteHandler(Route route, Queue<Destination> remaining, RouteOptimizer optimizer) {
        this.route = route;
        this.remaining = remaining;
        this.optimizer = optimizer;
    }

    public RouteHandler addDestination(Location currentLocation, Destination newDestination) {
        remaining.add(newDestination);

        return new RouteHandler(route.addDestination(newDestination), optimizer.optimizeRoute(currentLocation, remaining, route.getEnd()), optimizer);
    }

    public RouteHandler changeEnd(Location currentLocation, Location endLocation) {
        return new RouteHandler(route.changeEnd(endLocation), optimizer.optimizeRoute(currentLocation, remaining, endLocation), optimizer);
    }

    public Destination nextDestination() {
        return remaining.poll();
    }

    public double sum() {
        double sum = 0;

        for (Destination dest: route.getDestinations()) {
            sum += dest.isDelivered() ? dest.getRate().getValue() : 0;
        }

        return sum;
    }
}
