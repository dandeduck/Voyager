package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.Queue;

public interface TSPSolver {
    Queue<MathDestination> solve(MathDestination start, Collection<MathDestination> destinations, MathDestination end);
}
