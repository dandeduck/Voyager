package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Route {
    private final List<Destination> destinations;

    public Route(Collection<Destination> destinations) {
        this.destinations = new ArrayList<>(destinations);
    }

    public List<Destination> getDestinations() {
        return Collections.unmodifiableList(destinations);
    }
}
