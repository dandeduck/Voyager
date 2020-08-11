package com.navapp.navigation.util.math.TSP;

import com.navapp.navigation.util.math.MathLocation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//This class is based on the code from the Heuristics-TSP library by Sinclert Pérez, @Sinclert on Github, see Heuristics-TSP-license.md
public class HelpKarpSolver<T extends MathLocation> implements TSPSolver<T> {
    private double optimalCost;
    private List<T> optimalPath;

    public HelpKarpSolver() {
        resetVars();
    }

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

        costs[costs.length-1][0] = 0.0; //dummy's cost to start is 0
        costs[costs.length-1][costs.length-2] = 0.0; //dummy's cost to end is also 0
        combinedLocations.add(null);

        return solve(costs, combinedLocations);
    }

    public Queue<T> solve(Double[][] costs, List<T> allLocations) {
        resetVars();
        int[] vertices = new int[costs.length - 1];

        for (int i = 1; i < costs.length; i++)
            vertices[i - 1] = i;

        solve(costs, 0, 0, vertices, new ArrayList<>(), allLocations);
        optimalPath.remove(0); //remove start location
        optimalPath.remove(optimalPath.size()-1); //remove dummy

        return new ArrayDeque<>(optimalPath);
    }

    private double solve(Double[][] costs, int initial, double costUntilHere, int[] vertices, List<T> path, List<T> allLocations) {
        path.add(allLocations.get(initial));
        int length = vertices.length;
        double newCostUntilHere;

        if (length == 0) { // Exit case, if there are no more options to evaluate (last node)
            newCostUntilHere = costUntilHere + costs[initial][0];

            if (newCostUntilHere < optimalCost) { // If its cost is lower than the stored one
                optimalCost = newCostUntilHere;
                optimalPath.addAll(path);
            }

            return (costs[initial][0]);
        }


        // If the current branch has higher cost than the stored one: stop traversing
        else if (costUntilHere > optimalCost)
            return 0;

        // Common case, when there are several nodes in the list
        else {
            int[][] newVertices = new int[length][(length - 1)];
            double costCurrentNode;
            double costChild;
            double bestCost = Double.MAX_VALUE;

            for (int i = 0; i < length; i++) { // For each of the nodes of the list
                for (int j = 0, k = 0; j < length; j++, k++) { // Each recursion new vertices list is constructed
                    if (j == i) { // The current child is not stored in the new vertices array
                        k--;
                        continue;
                    }
                    newVertices[i][k] = vertices[j];
                }

                costCurrentNode = costs[initial][vertices[i]]; // Cost of arriving the current node from its parent
                newCostUntilHere = costCurrentNode + costUntilHere; // Here the cost to be passed to the recursive function is computed
                costChild = solve(costs, vertices[i], newCostUntilHere, newVertices[i], path, allLocations); // RECURSIVE CALLS TO THE FUNCTION IN ORDER TO COMPUTE THE COSTS

                double totalCost = costChild + costCurrentNode; // The cost of every child + the current node cost is computed
                if (totalCost < bestCost) // Finally we select from the minimum from all possible children costs
                    bestCost = totalCost;
            }

            return bestCost;
        }
    }

    private void resetVars() {
        optimalCost = Double.MAX_VALUE;
        optimalPath = new ArrayList<>();
    }
}
