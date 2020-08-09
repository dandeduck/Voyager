package com.navapp.navigation.util.math;

import java.util.Collection;
import java.util.Queue;

//This class is based on the code from the Heuristics-TSP library by Sinclert Pérez, @Sinclert on Github, see Heuristics-TSP-license.md
public class HelpKarpSolver implements TSPSolver {
    private final Double[][] distances;

    public HelpKarpSolver() {
        distances = new Double[0][];
    }

    @Override
    public Queue<MathLocation> solve(MathLocation start, Collection<MathLocation> locations, MathLocation end) {
        return null;
    }
}
