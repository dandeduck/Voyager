package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Route {
    private final List<Destination> destinations;
    private final Address end;

    public Route(Collection<Destination> destinations, Address end) {
        this.destinations = new ArrayList<>(destinations);
        this.end = end;
    }

    public List<Destination> destinations() {
        return destinations;
    }

    public Address end() {
        return end;
    }
}
