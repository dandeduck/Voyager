package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Location;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Route {
    private final List<Destination> destinations;
    private final Location end;

    public Route(Collection<Destination> destinations, Location end) {
        this.destinations = new ArrayList<>(destinations);
        this.end = end;
    }

    public Route changeEnd(Location newEnd) {
        return new Route(destinations, newEnd);
    }

    public Route addDestination(Destination destination) {
        List<Destination> newList = new ArrayList<>(destinations);
        newList.add(destination);
        return new Route(newList, end);
    }

    public List<Destination> getDestinations() {
        return Collections.unmodifiableList(destinations);
    }

    public Location getEnd() {
        return end;
    }
}
