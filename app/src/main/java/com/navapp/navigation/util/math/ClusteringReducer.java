package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.List;

public interface ClusteringReducer {
    public List<LocationCluster> reduceClusters(Collection<LocationCluster> clusters);
}
