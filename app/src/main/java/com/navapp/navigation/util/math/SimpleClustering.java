package com.navapp.navigation.util.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SimpleClustering implements ClusteringUtil {
    private final int maxClusterCount;
    private final TSPSolver solver;

    public SimpleClustering(int maxClusterCount, TSPSolver solver) {
        this.maxClusterCount = maxClusterCount;
        this.solver = solver;
    }

    @Override
    public List<MathDestination> deviceIntoClusters(MathDestination start, Collection<MathDestination> destinations, MathDestination end) {
        List<MathDestination> clusters = new ArrayList<>(destinations);

        while(clusters.size() > maxClusterCount) {
            double minCost = -1;
            MathDestination[] minCostDestinations = new MathDestination[2];

            for (MathDestination outer: clusters) {
                for (MathDestination inner: clusters) {
                    double cost = outer.cost(inner);
                    if(cost > 0) {
                        if(cost < minCost || minCost == -1) {
                            minCost = cost;
                            minCostDestinations[0] = outer;
                            minCostDestinations[1] = inner;
                        }
                    }
                }
            }

            clusters.remove(minCostDestinations[0]);
            clusters.remove(minCostDestinations[1]);
            clusters.add(new DestinationCluster(start, Arrays.asList(minCostDestinations), end, solver));
        }

        return clusters;
    }
}
