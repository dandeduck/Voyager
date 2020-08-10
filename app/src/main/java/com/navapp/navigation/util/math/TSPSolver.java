package com.navapp.navigation.util.math;

import java.util.List;
import java.util.Queue;

public interface TSPSolver<T extends MathLocation> {
    Queue<T> solve(T start, List<T> locations, T end);
}
