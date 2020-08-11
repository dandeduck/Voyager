package com.navapp.navigation.util.math;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LocationCluster implements MathLocation {
    private final List<MathLocation> locations;

    public LocationCluster(MathLocation... locations) {
        this(Arrays.asList(locations));
    }

    public LocationCluster(Collection<MathLocation> locations) {
        this.locations = new ArrayList<>(locations);
    }

    public LocationCluster then(LocationCluster nextCluster) {
        List<MathLocation> combinedList = new ArrayList<>(locations);
        combinedList.addAll(nextCluster.locations);

        return new LocationCluster(combinedList);
    }

    public LocationCluster order(MathLocation start, MathLocation end, TSPSolver<MathLocation> solver) {
        return new LocationCluster(new ArrayDeque<>(solver.solve(start, new ArrayList<>(locations), end)));
    }

    @Override
    public double cost(MathLocation otherLocation) {
        double minCost = Double.MAX_VALUE;

        for (MathLocation location : locations) {
            double cost = location.cost(otherLocation);

            if(cost < minCost)
                minCost = cost;
        }

        return minCost;
    }

    public boolean isCloserToTheEnd(MathLocation location) {
        return location.cost(locations.get(0)) > location.cost(locations.get(locations.size()-1));
    }

    public Collection<MathLocation> getLocations() {
        return locations;
    }

    public int size() {
        return locations.size();
    }
}
