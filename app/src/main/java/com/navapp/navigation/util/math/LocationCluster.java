package com.navapp.navigation.util.math;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class LocationCluster implements MathLocation {
    private final Deque<MathLocation> destinations;

    public LocationCluster(MathLocation start, Collection<MathLocation> destinations, MathLocation end, TSPSolver solver) {
        this.destinations = new ArrayDeque<>(solver.solve(start, destinations, end));
    }

    @Override
    public double cost(MathLocation destination) {
        return Math.min(destinations.getFirst().cost(destination), destinations.getLast().cost(destination));
    }
}
