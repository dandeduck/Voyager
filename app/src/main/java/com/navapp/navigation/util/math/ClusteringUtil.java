package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.List;

public interface ClusteringUtil {
    List<MathLocation> reduceClusters(MathLocation start, Collection<LocationCluster> clusters, MathLocation end);
}
