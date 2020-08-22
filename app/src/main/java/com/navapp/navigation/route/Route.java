package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Route {
    private final List<Destination> destinations;

    public Route(Destination... destinations) {
        this(Arrays.asList(destinations));
    }

    public Route(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return Collections.unmodifiableList(destinations);
    }

    public double calcRateSum() {
        double sum = 0;

        for (Destination destinatoin : destinations)
            sum += destinatoin.getRate().getValue();

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;
        return destinations.equals(route.destinations);
    }
}
