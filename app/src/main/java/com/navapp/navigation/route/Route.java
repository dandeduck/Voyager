package com.navapp.navigation.route;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;

public class Route {
    private final Deque<Destination> destinations;
    private final List<Destination> destinationsCopy;
    private final Address end;

    public Route(Collection<Destination> destinations, Address end) {
        this.destinations = new ArrayDeque<>(destinations);
        destinationsCopy = new ArrayList<>(destinations);
        this.end = end;
    }

    public Deque<Destination> destinationsLeft() {
        return destinations;
    }

    public List<Destination> allDestinations() {
        return destinationsCopy;
    }

    public Destination nextDestination() {
        return destinations.pop();
    }

    public void addDestination(Destination destination, Address currentAddress) {
        destinations.push(destination);
        destinationsCopy.add(destination);
        optimize(currentAddress);
    }

    public void optimize(Address start) {
        throw new UnsupportedOperationException();
    }

    public double sum() {
        double sum = 0;

        for (Destination dest: destinationsCopy) {
            sum += dest.isDelivered() ? dest.rate() : 0;
        }

        return sum;
    }
}
