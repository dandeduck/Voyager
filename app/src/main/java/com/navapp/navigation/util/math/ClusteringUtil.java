package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.List;

public interface ClusteringUtil {
    List<MathDestination> reduceClusters(MathDestination start, Collection<DestinationCluster> clusters, MathDestination end);
}
