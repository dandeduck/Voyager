package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.Queue;

public interface TSPSolver {
    Queue<MathLocation> solve(MathLocation start, Collection<MathLocation> destinations, MathLocation end);
}
