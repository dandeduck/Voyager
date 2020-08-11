package com.navapp.navigation.util.math;

import com.navapp.navigation.util.math.TSP.TSPSolver;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ClusteringUtil {
    public static Queue<LocationCluster> orderClusters(MathLocation start, List<LocationCluster> clusters, MathLocation end, TSPSolver<LocationCluster> clusterSolver, TSPSolver<MathLocation> locationSolver) {
        List<LocationCluster> orderedClusters = new ArrayList<>(clusterSolver.solve(new LocationCluster(start), clusters, new LocationCluster(end)));
        Queue<LocationCluster> result = new ArrayDeque<>();

        result.add(new LocationCluster(orderedClusters.get(0).order(start, orderedClusters.get(1), locationSolver)));

        for (int i = 1; i < orderedClusters.size()-1; i++)
            result.add(new LocationCluster(orderedClusters.get(i).order(orderedClusters.get(i-1), orderedClusters.get(i+1), locationSolver)));

        result.add(new LocationCluster(orderedClusters.get(orderedClusters.size()-1).order(orderedClusters.get(orderedClusters.size()-2), end, locationSolver)));

        return result;
    }
}
