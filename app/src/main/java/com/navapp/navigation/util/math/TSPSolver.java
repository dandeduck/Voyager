package com.navapp.navigation.util.math;

import java.util.List;
import java.util.Queue;

public interface TSPSolver {
    Queue<MathLocation> solve(MathLocation start, List<MathLocation> locations, MathLocation end);
}
