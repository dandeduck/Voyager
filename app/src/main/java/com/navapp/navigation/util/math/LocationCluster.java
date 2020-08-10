package com.navapp.navigation.util.math;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LocationCluster implements MathLocation {
    private final Deque<MathLocation> locations;

    public LocationCluster(MathLocation... locations) {
        this(Arrays.asList(locations));
    }

    public LocationCluster(Collection<MathLocation> locations) {
        this.locations = new ArrayDeque<>(locations);
    }

    public LocationCluster order(MathLocation start, MathLocation end, TSPSolver solver) {
        return new LocationCluster(new ArrayDeque<>(solver.solve(start, new ArrayList<>(locations), end)));
    }

    @Override
    public double cost(MathLocation location) { // won't work well when not ordered, but there is no pretty way to check that besides asking for a flag in the ctor
        return Math.min(locations.getFirst().cost(location), locations.getLast().cost(location));
    }

    public Collection<MathLocation> getLocations() {
        return locations;
    }
}
