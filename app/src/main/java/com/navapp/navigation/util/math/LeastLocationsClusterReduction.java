package com.navapp.navigation.util.math;

import java.util.ArrayList;
import java.util.List;

public class LeastLocationsClusterReduction implements ClusteringReducer {
    private final int maxClusterCount;

    public LeastLocationsClusterReduction(int maxClusterCount) {
        this.maxClusterCount = maxClusterCount;
    }

    @Override
    public List<LocationCluster> reduceIndividuallyOrderedClusters(List<LocationCluster> clusters) {
        List<LocationCluster> tmp = new ArrayList<>(clusters);

        while (tmp.size() > maxClusterCount)
            integrateSmallestCluster(tmp);

        return tmp;
    }

    private void integrateSmallestCluster(List<LocationCluster> clusters) {
        combineSmallestCluster(clusters, indexOfClusterWithLeastLocations(clusters));
    }

    private int indexOfClusterWithLeastLocations(List<LocationCluster> clusters) {
        int smallestClusterIndex = 0;

        for (int i = 0; i < clusters.size(); ++i)
            if(clusters.get(i).size() < clusters.get(smallestClusterIndex).size())
                smallestClusterIndex = i;

        return smallestClusterIndex;
    }

    private void combineSmallestCluster(List<LocationCluster> clusters, int smallestClusterIndex) {
        LocationCluster smallestCluster = clusters.remove(smallestClusterIndex);
        int indexOfClosestCluster = indexOfClosestCluster(clusters, smallestCluster);

        if(smallestCluster.isCloserToTheEnd(clusters.get(indexOfClosestCluster)))
            clusters.set(smallestClusterIndex, smallestCluster.then(clusters.get(smallestClusterIndex)));
        else
            clusters.set(smallestClusterIndex-1, clusters.get(smallestClusterIndex-1).then(smallestCluster));
    }

    private int indexOfClosestCluster(List<LocationCluster> clusters, LocationCluster cluster) {
        int indexOfClosestCluster = 0;

        for (int i = 0; i < clusters.size(); ++i)
            if(clusters.get(i).cost(cluster) < clusters.get(indexOfClosestCluster).cost(cluster))
                indexOfClosestCluster = i;

        return indexOfClosestCluster;
    }
}
