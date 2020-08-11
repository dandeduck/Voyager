package com.navapp.navigation.util.math;

import com.navapp.navigation.util.math.TSP.TSPSolver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LocationCluster implements MathLocation {
    private final List<MathLocation> locations;

    public LocationCluster(MathLocation... locations) {
        this(Arrays.asList(locations));
    }

    public LocationCluster(Collection<MathLocation> locations) {
        this.locations = new ArrayList<>(locations);
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

    public Collection<MathLocation> getLocations() {
        return locations;
    }

    public int size() {
        return locations.size();
    }
}
