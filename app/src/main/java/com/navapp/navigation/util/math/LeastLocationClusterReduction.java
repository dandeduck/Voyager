package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.List;

public class LeastLocationClusterReduction implements ClusteringReducer {
    private final int maxClusterCount;
    private final TSPSolver solver;

    public LeastLocationClusterReduction(int maxClusterCount, TSPSolver solver) {
        this.maxClusterCount = maxClusterCount;
        this.solver = solver;
    }

    @Override
    public List<LocationCluster> reduceClusters(Collection<LocationCluster> clusters) {
        return null;
    }
}
