package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;

import java.util.Collections;
import java.util.List;

public class Route {
    private final List<Destination> destinations;

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
}
