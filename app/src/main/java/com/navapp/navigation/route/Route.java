package com.navapp.navigation.route;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.navapp.navigation.destination.Destination;

import java.util.ArrayDeque;
import java.util.Collection;

public class Route {
    private final ArrayDeque<Destination> destinations;
    private final ArrayDeque<Destination> destinationsCopy;

    public Route(Collection<Destination> destinations) {
        this.destinations = new ArrayDeque<>(destinations);
        destinationsCopy = this.destinations.clone();
    }

    public Destination nextDestination() {
        return destinations.pop();
    }

    public void addDestination(Destination destination) {
        destinations.push(destination);
        optimize();
    }

    public void optimize() {
        //do stuff
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public double sum() {
        return destinationsCopy.stream()
                .mapToDouble(destination -> destination.isDelivered() ? destination.rate() : 0)
                .sum();
    }
}
