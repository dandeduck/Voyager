package com.navapp.navigation.util.math;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class DestinationCluster implements MathDestination{
    private final Deque<MathDestination> destinations;

    public DestinationCluster(MathDestination start, Collection<MathDestination> destinations, MathDestination end, TSPSolver solver) {
        this.destinations = new ArrayDeque<>(solver.solve(start, destinations, end));
    }

    @Override
    public double cost(MathDestination destination) {
        return Math.min(destinations.getFirst().cost(destination), destinations.getLast().cost(destination));
    }
}
