package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.List;

public interface ClusteringUtil {
    List<MathDestination> deviceIntoClusters(MathDestination start, Collection<MathDestination> destinations, MathDestination end);
}
