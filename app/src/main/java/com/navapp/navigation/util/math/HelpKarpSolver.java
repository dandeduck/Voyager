package com.navapp.navigation.util.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//This class is based on the code from the Heuristics-TSP library by Sinclert Pérez, @Sinclert on Github, see Heuristics-TSP-license.md
public class HelpKarpSolver<T extends MathLocation> implements TSPSolver<T> {
    @Override
    public Queue<T> solve(T start, List<T> locations, T end) {
        List<T> combinedLocations = new ArrayList<>();
        combinedLocations.add(start);
        combinedLocations.addAll(locations);
        combinedLocations.add(end);

        Double[][] costs = new Double[combinedLocations.size()+1][combinedLocations.size()+1]; // It's +1 because we need a dummy that makes it end at end and not at start

        for (int i = 0; i < combinedLocations.size(); i++)
            for (int j = 0; j < combinedLocations.size(); j++)
                costs[i][j] = locations.get(i).cost(locations.get(j));

        for (int i = 0; i < costs.length; i++) {
            costs[i][costs.length-1] = Double.MAX_VALUE;
            costs[costs.length-1][i] = Double.MAX_VALUE;
        }

        costs[costs.length-1][0] = 0.0;//dummy's cost to start is 0
        costs[costs.length-1][costs.length-2] = 0.0;//dummy's cost to end is also 0
        combinedLocations.add(null);

        return solve(costs, combinedLocations);
    }

    public Queue<T> solve(Double[][] costs, List<T> allLocations) {

        return null;
    }

    private Queue<T> solve(Double[][] costs, int initial, double costUntilHere, Double[] vertices, List<T> allLocations) {

        return null;
    }
}
