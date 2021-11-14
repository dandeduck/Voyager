package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Route {
    private final List<Destination> destinations;

    public Route(Destination... destinations) {
        this(Arrays.asList(destinations));
    }

    public Route(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public Destination getOrigin() {
        return destinations.get(0);
    }

    public Destination getDestination() {
        return destinations.get(destinations.size()-1);
    }

    public List<Destination> getWaypoints() {
        return Collections.unmodifiableList(destinations.subList(1, destinations.size()-1));
    }

    public double calcRateSum() {
        double sum = 0;

        for (Destination destination : destinations)
            sum += destination.getRate().getValue();

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;
        return destinations.equals(route.destinations);
    }

    @Override
    public String toString() {
        return destinations.toString();
    }
}
