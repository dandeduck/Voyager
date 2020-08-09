package com.navapp.navigation.util.math;

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
    public List<MathDestination> reduceClusters(MathDestination start, Collection<DestinationCluster> clusters, MathDestination end) {
        return null;
    }
}
