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
    public long distance(GraphLocation otherLocation) {
        long minDistance = Long.MAX_VALUE;

        for (GraphLocation location : locations) {
            long distance = location.distance(otherLocation);

            if(distance < minDistance)
                minDistance = distance;
        }

        return minDistance;
    }

    public Collection<GraphLocation> getLocations() {
        return locations;
    }

    public int size() {
        return locations.size();
    }
}
