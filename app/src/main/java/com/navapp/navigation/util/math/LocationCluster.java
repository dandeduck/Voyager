package com.navapp.navigation.util.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LocationCluster implements GraphLocation {
    private final List<GraphLocation> locations;

    public LocationCluster(GraphLocation... locations) {
        this(Arrays.asList(locations));
    }

    public LocationCluster(Collection<GraphLocation> locations) {
        this.locations = new ArrayList<>(locations);
    }

    @Override
    public double distance(GraphLocation otherLocation) {
        double minCost = Double.MAX_VALUE;

        for (GraphLocation location : locations) {
            double cost = location.distance(otherLocation);

            if(cost < minCost)
                minCost = cost;
        }

        return minCost;
    }

    public Collection<GraphLocation> getLocations() {
        return locations;
    }

    public int size() {
        return locations.size();
    }
}
