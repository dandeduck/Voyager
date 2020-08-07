package com.navapp.navigation.route;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.List;
import java.util.function.Supplier;

public class RouteHandler {
    private final Supplier<Address> locationSupplier;
    private Route route;
    private int currentDestination;

    public RouteHandler(Supplier<Address> locationSupplier, Route route) {
        this.locationSupplier = locationSupplier;
        this.route = route;
        currentDestination = -1;
    }

    public Destination nextDestination() {
        currentDestination++;
        return route.destinations().get(currentDestination);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Route addDestination(Destination destination) {
        List<Destination> destinations = route.destinations();
        destinations.add(destination);
        route = new Route(destinations, route.end());
        
        return optimizeRoute(locationSupplier.get());
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
