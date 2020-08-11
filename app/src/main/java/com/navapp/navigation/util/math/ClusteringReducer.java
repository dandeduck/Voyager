package com.navapp.navigation.util.math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface ClusteringReducer {
    default List<LocationCluster> reduceIndividuallyOrderedClusters(Collection<LocationCluster> clusters) {
        return reduceIndividuallyOrderedClusters(new ArrayList<>(clusters));
    }

    List<LocationCluster> reduceIndividuallyOrderedClusters(List<LocationCluster> clusters);
}
