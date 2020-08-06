package com.navapp.navigation.route;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.navapp.navigation.destination.Destination;
import com.navapp.navigation.destination.data.Address;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Route {
    private final ArrayDeque<Destination> destinations;
    private final List<Destination> destinationsCopy;
    private final Address end;

    public Route(Collection<Destination> destinations, Address end) {
        this.destinations = new ArrayDeque<>(destinations);
        destinationsCopy = new ArrayList<>(destinations);
        this.end = end;
    }

    public ArrayDeque<Destination> destinationsLeft() {
        return destinations.clone();
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
        //do stuff
        //also may be optimize the copy (if it's not too slow...)
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public double sum() {
        return destinationsCopy.stream()
                .mapToDouble(destination -> destination.isDelivered() ? destination.rate() : 0)
                .sum();
    }
}
